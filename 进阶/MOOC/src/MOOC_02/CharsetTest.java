package MOOC_02;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

public class CharsetTest {

    public static void main(String[] args) {
        Charset c = Charset.defaultCharset();
        System.out.println(c.name());

        SortedMap<String,Charset> sm = Charset.availableCharsets();

        Set<String> keySet = sm.keySet();
        System.out.println("java支持的所有字符集：");
        for(String s : keySet) {
            System.out.println(s);
        }
    }
}
