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
         * ������
         *  ��Lambda���ʽ �� �����ӿڵ�һ������,  �ʣ��ø�ֵ������
         *
        Lambda���ʽ�� (Trade t)->t.getStatus().equals("NEW");
        ��ࣺ ����
        �Ҳࣺ������ -----��ITrade.check()�ķ�����
        ���������ӿ�ֻ��һ�����󷽷������Զ�ӦΪITrade.check()
         */
        /*
        ������������ֵ����У��Ҳ� �ֱ� ��Trade.check()�����˲�ͬ��ʵ�֡�
        �Ӷ���ͬ����ITrade���͵�����ʵ����newTradeChecker�� bigTreadeLambda �����ǵ�check���������в�ͬ��ʵ�֡�
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
 Lambda���ʽ�Ǻ����ӿڵ�һ������
 �����ӿڣ� ֻ��һ�����󷽷�
 */
/**
 Lambda���ƣ�
 ͬһ�����ӿڣ���������Ҫ��ʱ�����ʵ�֡�
 */