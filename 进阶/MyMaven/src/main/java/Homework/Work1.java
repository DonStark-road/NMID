package Homework;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.Arrays;
import java.util.Scanner;

public class Work1 {
    public static void main(String[] args) {
        System.out.println("请输入一句汉语句子：");
        Scanner input = new Scanner(System.in);
        String chinese = input.nextLine();
        String[][] pinyin = new String[chinese.length()][];
        for (int i = 0; i < chinese.length(); i++) {
            pinyin[i] = PinyinHelper.toHanyuPinyinStringArray(chinese.charAt(i));
        }
        System.out.println(Arrays.deepToString(pinyin));
    }
}
