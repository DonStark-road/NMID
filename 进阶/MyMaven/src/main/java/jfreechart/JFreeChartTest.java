package jfreechart;

import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class JFreeChartTest {
    public static void main(String[] args) {
        writeBarChart("F:\\School\\Notebook\\pics\\统计图\\bar.JPEG");
        writePieChart("F:\\School\\Notebook\\pics\\统计图\\pie.JPEG");
        writeLineChart("F:\\School\\Notebook\\pics\\统计图\\line.JPEG");
    }

    public static StandardChartTheme getChineseTheme() {
        StandardChartTheme chineseTheme = new StandardChartTheme("CN");
        chineseTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        chineseTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        chineseTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
        return chineseTheme;
    }

    public static void writeBarChart(String fileName) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(11, "", "第一季度");
        dataset.addValue(41, "", "第二季度");
        dataset.addValue(51, "", "第三季度");
        dataset.addValue(4, "", "第四季度");

        ChartFactory.setChartTheme(getChineseTheme());
        JFreeChart chart = ChartFactory.createBarChart("柱状图", "2018年", "产品总量", dataset);

        try {
            ChartUtils.saveChartAsJPEG(new File(fileName), chart, 600, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writePieChart(String fileName) {
        DefaultPieDataset<String> pds = new DefaultPieDataset<String>();
        pds.setValue("C人数", 100);
        pds.setValue("C++人数", 200);
        pds.setValue("Java人数", 300);
        try {
            ChartFactory.setChartTheme(getChineseTheme());
            JFreeChart chart = ChartFactory.createPieChart("饼图", pds);

            ChartUtils.saveChartAsJPEG(new File(fileName), chart, 600, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeLineChart(String fileName) {
        DefaultCategoryDataset lines = new DefaultCategoryDataset();
        //第一条线
        lines.addValue(100, "Java核心技术", "1月");
        lines.addValue(200, "Java核心技术", "2月");
        lines.addValue(400, "Java核心技术", "3月");
        lines.addValue(500, "Java核心技术", "4月");

        //第二条线
        lines.addValue(100, "Java核心技术（进阶）", "1月");
        lines.addValue(400, "Java核心技术（进阶）", "2月");
        lines.addValue(900, "Java核心技术（进阶）", "3月");
        try {
            ChartFactory.setChartTheme(getChineseTheme());
            JFreeChart chart = ChartFactory.createLineChart("折线图", "时间", "人数", lines);
            ChartUtils.saveChartAsJPEG(new File(fileName), chart, 600, 300);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
