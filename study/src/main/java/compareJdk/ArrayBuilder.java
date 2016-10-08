package compareJdk;
import java.util.*;
/**
 * Created by liuda on 2016/10/4.
 */
public class ArrayBuilder {
    @SafeVarargs //可取消堆污染警告
    public static <T> void addToList (List<T> listArg, T... elements) {
        for (T x : elements) {
            listArg.add(x);
        }
    }

    public static void faultyMethod(List<String>... l) {
        Object[] objectArray = l;  // Valid
        objectArray[0] = Arrays.asList(new Integer(42));
        String s = l[0].get(0);    // ClassCastException thrown here
    }
}
