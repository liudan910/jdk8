package compareJdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuda on 2016/10/4.
 */
public class TypeInference {
    public static void main(String[] args){
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.addAll(Arrays.asList()); //jdk7增强类型推断
    }
}
