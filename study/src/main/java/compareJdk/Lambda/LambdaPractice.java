package compareJdk.Lambda;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by liuda on 2016/10/4.
 */
/*
Ŀ������Lambda������һ�������ӿڣ� ��������Lambda���ʽ�������ǣ�����������һ�������ӿ�
 */
public class LambdaPractice {
    public static void main(String[] args){
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        //test1(()->{return new HashSet();});// �����ǣ�test1�����಻��һ�������ӿڣ�����һ����
        test2(() -> {
            return new HashSet();
        });
        test3(()->{return new HashSet();});
    }

    public static void test1(HashSet xx){}
    public static <T> void test2(Supplier<Collection<T>> xx){}
    public static <T,DEST extends Collection<T>> void test3(Supplier<DEST> collectionFactory){
        DEST dest = collectionFactory.get();
    }

}
