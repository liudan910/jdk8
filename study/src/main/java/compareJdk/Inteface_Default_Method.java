package compareJdk;

/**
 * Created by liuda on 2016/10/4.
 */
interface Car{
    public double getHeght();
    public double getWidth();
    static public String getCompany() {
        return "Foster";
    }
    //  java8 �����ԣ� �ڽӿ�������Ĭ�Ϸ���������ʵ������и÷�����ʵ���಻����ȥ�̳������ࡣ
    default String getCompayName(){
        return "Foter";
    }

}
class MiniCar implements Car {

    @Override
    public double getHeght() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

}
public class Inteface_Default_Method {
    public static void main(String[] args){
        Car car = new MiniCar();
        System.out.println(car.getCompayName());
    }

}
