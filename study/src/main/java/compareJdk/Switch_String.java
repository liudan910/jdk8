package compareJdk;
import static java.lang.System.out;
/**
 * Created by liuda on 2016/10/4.
 */
public class Switch_String {
    public static void main(String[] args){
        judgeString("cc");
    }
    public static void judgeString(String xx){
        switch (xx){
            case "aa":
                out.printf("%s-11",xx); break;
            case "bb":
                out.printf("%s-22",xx); break;
            case "cc":
                out.printf("%s-33",xx); break;
            default:
                break;

        }
    }
}
