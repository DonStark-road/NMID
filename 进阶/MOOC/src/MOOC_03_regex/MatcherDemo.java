package MOOC_03_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherDemo {
    private static final String REGEX = "\\bdog\\b";// \b表示边界
    private static final String INPUT = "dog dog dog doggie dogg";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);

        Matcher m = p.matcher(INPUT);
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("Matcher number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }
    }
}
