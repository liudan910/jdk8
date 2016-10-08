package compareJdk;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Thread.sleep;

/**
 * Created by liuda on 2016/10/4.
 */
public class Try_With_Resource  implements Closeable{
    public static void main(String[] args){
        try{
            System.out.println(readFirstLineFromFile2());
            sleep(20000);
        }catch (Exception e){

        }
    }
    /*try-with-resource 在try语句定义输入源，可自动关闭输入源。 reaFirstLineFromFile（）与 reaFirstLineFromFile（）效果相同。
     try-with-resource 的catch,finally均将运行在try()中定义的输入源关闭之后。
     */
    public static String readFirstLineFromFile()throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("D://test.txt"))){
            return br.readLine();
        }
    }
    public static String readFirstLineFromFile2()throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("D://test.txt"));
        try{
            return br.readLine();
        }finally {
            if(br!=null) br.close();
        }
    }
    //try（）中可带多个输入源
   /* public static String readFirstLineFromFile3()throws IOException{
        String zipFileName = "";
        String outFilePath = new Path();
        String charSet = new Charset("utf-8");
        try(java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
            java.io.BufferedWriter write = java.nio.file.Files.newBufferedWriter(outFilePath), charSet)){

        }
    }
    */

    @Override
    public void close() throws IOException {

    }
}
