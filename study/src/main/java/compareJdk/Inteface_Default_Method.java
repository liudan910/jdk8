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
    //  java8 新特性： 在接口中设置默认方法，所有实现类均有该方法，实现类不必再去继承其他类。
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
