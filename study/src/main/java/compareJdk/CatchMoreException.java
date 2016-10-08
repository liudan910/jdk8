package compareJdk;

import java.io.*;

/**
 * Created by liuda on 2016/10/4.
 */
public class CatchMoreException {
    public static void main(String[] args) throws  Exception{
        try {
            test("ex");
        }catch(IOException |NullPointerException ex){
            if(ex.equals("ioException")){
                throw new IOException();
            }else{
                throw new NullPointerException();
            }
        }
    }
    public static void test(String ex)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(""));

    }
}
