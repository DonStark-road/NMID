package stringinputstream;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class String2InputStream {
    public static void main(String[] args) {
        //构造字符串列表
        List<String> names = new LinkedList<String>();
        names.add("Xiaohong");
        names.add("Xiaoming");
        names.add("Daming");
        names.add("Xiaohei");

        //合并为一个字符串，以逗号相连
        String nameStr = String.join(",",names);

        //将字符串作为默认的输入流
        InputStream in = IOUtils.toInputStream(nameStr, Charsets.toCharset("UTF-8"));
        //重置系统的输入流
        System.setIn(in);

        //模拟键盘输入，OJ平台测试用例的原理
        //此处也可以换为一个文件输入流
        Scanner input = new Scanner(System.in);
        input.useDelimiter(",");
        while (input.hasNext()) {
            System.out.println(input.next());
        }
    }
}
