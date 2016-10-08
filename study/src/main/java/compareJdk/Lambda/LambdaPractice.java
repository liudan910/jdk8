package compareJdk.Lambda;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by liuda on 2016/10/4.
 */
/*
目标类型Lambda必须是一个函数接口： 参数传入Lambda表达式的条件是：参数类型是一个函数接口
 */
public class LambdaPractice {
    public static void main(String[] args){
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        //test1(()->{return new HashSet();});// 报错是：test1参数类不是一个函数接口，而是一个类
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
