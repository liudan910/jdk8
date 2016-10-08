package compareJdk.Lambda;

import java.time.LocalDate;

import java.util.*; //当同一个包内的引用达到5个以上，会自动 用 *来聚合；
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

//关键点：函数接口：Supplier, 泛化:T，  继承泛化Collection:DEST extends Collection<T>
public class LambdaTest {
    public static <T, SOURCE extends Collection<T>,DEST extends Collection<T>>  DEST tranferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactlry
    ){
        DEST result = collectionFactlry.get(); //实现Supplier接口后，可调用get方法得到对象
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

        //普通方式： 实现Comparter接口
        //Arrays.sort(rosterAsArray, new PersonAgeComparator());

        //Lambda表达式
         Arrays.sort(rosterAsArray,(Person a,Person b)->{return a.getBirthday().compareTo(b.getBirthday());});

        //静态方法引用
        // Arrays.sort(rosterAsArray,Person::compareByAge);
        for(Person p : rosterAsArray){
            p.printPerson();
        }
        out.println("----------------");
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        /*java.util.function包中含有函数接口中，Suppelier: 仅包含一个get()方法，无参数，仅返回一个对象。
        因此，可以用lambda表达式invoke方法transferElement
        */
        Set<Person> rosterSetLamda =
                tranferElements(roster,()->{return new HashSet<>();});
        //构造方法引用 代替 Lambda表达式引用
        Set<Person> rosterSet = tranferElements(roster,HashSet::new);
        //利用流Strem输出
        rosterSet.stream().forEach(p->p.printPerson());
    }
}
