package compareJdk.Lambda;

import java.time.LocalDate;

import java.util.*; //��ͬһ�����ڵ����ôﵽ5�����ϣ����Զ� �� *���ۺϣ�
import java.util.function.Supplier;

import static java.lang.System.out;

/**
 * Created by liuda on 2016/10/4.
 */
class Person{
    public enum Sex{
        MALE, FEMALE
    }
    String name;
    LocalDate birthday;
    Sex gender;

    public Person(String name, LocalDate  birthday, Sex gender){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }
    public LocalDate getBirthday(){
        return birthday;
    }
    public static int compareByAge(Person a ,Person b){
        return a.birthday.compareTo(b.birthday);
    }
    public void printPerson(){out.println(name);}

}
class PersonAgeComparator implements Comparator<Person> {
    public int compare(Person a, Person b) {
        return a.getBirthday().compareTo(b.getBirthday());
    }
}

//�ؼ��㣺�����ӿڣ�Supplier, ����:T��  �̳з���Collection:DEST extends Collection<T>
public class LambdaTest {
    public static <T, SOURCE extends Collection<T>,DEST extends Collection<T>>  DEST tranferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactlry
    ){
        DEST result = collectionFactlry.get(); //ʵ��Supplier�ӿں󣬿ɵ���get�����õ�����
        for(T t : sourceCollection){
            result.add(t);
        }
        return result;
    }

    public static void lambdaTest(){
        List<Person> roster =  new ArrayList<Person>();
        Person person1 = new Person("LiMing",LocalDate.parse("2010-03-02"), Person.Sex.FEMALE);
        Person person2 = new Person("XiaoHong",LocalDate.parse("2009-03-02"), Person.Sex.FEMALE);
        Person person3 = new Person("LiXin",LocalDate.parse("2008-03-02"), Person.Sex.FEMALE);
        roster.add(person1);
        roster.add(person2);
        roster.add(person3);
        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
        for(Person p : rosterAsArray){
            p.printPerson();
        }
        out.println("----------------");

        //��ͨ��ʽ�� ʵ��Comparter�ӿ�
        //Arrays.sort(rosterAsArray, new PersonAgeComparator());

        //Lambda���ʽ
         Arrays.sort(rosterAsArray,(Person a,Person b)->{return a.getBirthday().compareTo(b.getBirthday());});

        //��̬��������
        // Arrays.sort(rosterAsArray,Person::compareByAge);
        for(Person p : rosterAsArray){
            p.printPerson();
        }
        out.println("----------------");
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        /*java.util.function���к��к����ӿ��У�Suppelier: ������һ��get()�������޲�����������һ������
        ��ˣ�������lambda���ʽinvoke����transferElement
        */
        Set<Person> rosterSetLamda =
                tranferElements(roster,()->{return new HashSet<>();});
        //���췽������ ���� Lambda���ʽ����
        Set<Person> rosterSet = tranferElements(roster,HashSet::new);
        //������Strem���
        rosterSet.stream().forEach(p->p.printPerson());
    }
}
