package com.jdk8.lambda;
import static java.lang.System.out;
/**
 * Created by liudan19 on 2016/10/8.
 */
public class FunctionInterface {
    public static void main(String[] args){
       // testITrade();
        testIString();
    }

    public static void testITrade(){
        ITrade newTradeChecker = (Trade t)->t.getStatus().equals("NEW");
        ITrade bigTreadeLambda = (Trade t)->t.getQuantity()>1000000;
        /**
         * 解析：
         *  个Lambda表达式 是 函数接口的一种类型,  故，该赋值语句成立
         *
        Lambda表达式： (Trade t)->t.getStatus().equals("NEW");
        左侧： 参数
        右侧：方法体 -----即ITrade.check()的方法体
        附：函数接口只有一个抽象方法。所以对应为ITrade.check()
         */
        /*
        在上述两条赋值语句中，右侧 分别 对Trade.check()进行了不同的实现。
        从而，同样是ITrade类型的两个实例：newTradeChecker、 bigTreadeLambda ，它们的check（）方法有不同的实现。
         */
    }
    public static void testIString(){
        IString iString = (String s1, String s2)->s1+s2;
        String s1 = "aa";
        String s2 = "bb";
        String s3 =iString.concatString(s1,s2);
        out.println(s3);
    }
}

class Trade{
    public String getStatus(){
        return "New";
    }
    public int getQuantity(){
        return 2000000;
    }
}
@FunctionalInterface
interface ITrade{
    public boolean check(Trade t);
}
@FunctionalInterface
interface IString{
    public String concatString(String s1,String s2);
}
/**
 Lambda表达式是函数接口的一种类型
 函数接口： 只有一个抽象方法
 */
/**
 Lambda优势：
 同一函数接口，可以在需要的时候进行实现。
 */