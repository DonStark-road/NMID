package MOOC_03_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static String REGEX = "a*b";//*表示限定前面的a可以有0或者多个（例 aab ab b）
    private static String INPUT = "aabfooaabfooabfoobcdd";
    private static String REPLACE = "-";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);

        StringBuffer sb = new StringBuffer();
        //全部替换
        while (m.find()) {
            m.appendReplacement(sb,REPLACE);
        }
        m.appendTail(sb);//加上最后的尾巴字符串
        System.out.println(sb.toString());

    }
}
