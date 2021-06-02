package tuofeng;

import com.google.common.base.CaseFormat;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class GuavaUtil {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(456);
        System.out.println(list);

        //直接初始化List数组
        List<Integer> integers = Lists.newArrayList(123,456);
        System.out.println(integers);

        //拆分字符串，忽略空字符串
        Iterable<String> spilt = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("123,321,,    abc");

        for(String s : spilt) {
            System.out.println(s);
        }

        //基于Google Guava下的驼峰命名
        String s1 = "CONSTANT_NAME";
        String s2 = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,s1);
        System.out.println(s2);//constantName
    }
}
