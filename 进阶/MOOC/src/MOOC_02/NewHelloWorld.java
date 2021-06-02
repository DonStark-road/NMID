package MOOC_02;

import java.util.Locale;
import java.util.ResourceBundle;

public class NewHelloWorld {
    public static void main(String[] args) {
        //取得系统默认的语言环境
        Locale myLocale = Locale.getDefault();

        System.out.println(myLocale);

        //根据指定的语言、国家环境加载资源文件
        //need properties
        ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.getDefault());

        //从资源文件中取得的消息
        System.out.println(bundle.getString("hello"));
    }
}
