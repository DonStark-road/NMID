package MOOC_04;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ImageTest {
    public static void main(String[] args) throws Exception {
        readAndWrite();
        readComparison();
        //cropImage("F:/School/Notebook/pics/four_girls.jpg", "F:/School/Notebook/pics/four_girls_trim.jpg",
        //        750, 250, 700, 300, "jpg", "jpg");
        combineImageHorizontally("F:/School/Notebook/pics/four_girls.jpg"
                ,"F:/School/Notebook/pics/four_girls.jpg","jpg","F:/School/Notebook/pics/four_girls_combine.jpg");
    }

    //不指定格式读图
    public static void readAndWrite() throws Exception {
        BufferedImage image = ImageIO.read(new File("F:/School/Notebook/pics/four_girls.jpg"));
        System.out.println("Height：" + image.getHeight());
        System.out.println("Width：" + image.getWidth());
        ImageIO.write(image, "png", new File("F:/School/Notebook/pics/four_girls_new.png"));
    }

    //指定格式读图
    public static void readComparison() throws Exception {
        System.out.println("============速度加载测试============");

        //ImageIO需要测试图片的类型，加载合适的ImageReader来读取图片，耗时更长
        long startTime = System.nanoTime();
        BufferedImage image = ImageIO.read(new File("F:/School/Notebook/pics/four_girls.jpg"));
        System.out.println("Height：" + image.getHeight());
        System.out.println("Width：" + image.getWidth());
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000.0 + "毫秒");

        //指定用jpg Reader来加载，速度会快很多
        startTime = System.nanoTime();
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = readers.next();
        System.out.println(reader.getClass().getName());
        ImageInputStream iis = ImageIO.createImageInputStream(new File("F:/School/Notebook/pics/four_girls.jpg"));
        reader.setInput(iis, true);
        System.out.println("Height：" + image.getHeight());
        System.out.println("Width：" + image.getWidth());
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000.0 + "毫秒");
    }

    //抠图
    public static void cropImage(String fromPth, String toPath, int x, int y, int width, int height
            , String readImageFormat, String writeImageFormat) throws Exception {
        FileInputStream fis = null;
        ImageInputStream iis = null;
        try {
            //读取原始图片文件
            fis = new FileInputStream(fromPth);
            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(readImageFormat);
            ImageReader reader = it.next();
            iis = ImageIO.createImageInputStream(fis);
            reader.setInput(iis, true);

            //定义一个矩形，并放入切割参数中
            ImageReadParam param = reader.getDefaultReadParam();
            Rectangle rectangle = new Rectangle(x, y, width, height);
            param.setSourceRegion(rectangle);

            //从源文件读取一个矩形大小的图像
            BufferedImage bi = reader.read(0, param);

            //写入到目标文件
            ImageIO.write(bi, writeImageFormat, new File(toPath));
        } finally {
            assert fis != null;
            fis.close();
            assert iis != null;
            iis.close();
        }
    }

    //水平拼接图片
    public static void combineImageHorizontally(String firstPath, String secondPath, String imageFormat, String toPath) {
        try {
            //读第一张图
            File first = new File(firstPath);
            BufferedImage imageOne = ImageIO.read(first);
            int width1 = imageOne.getWidth();
            int height1 = imageOne.getHeight();
            //从第一张图片中读取RGB
            int[] firstRGB = new int[width1 * height1];
            firstRGB = imageOne.getRGB(0, 0, width1, height1, firstRGB, 0, width1);

            //对第二张图片相同处理
            File second = new File(secondPath);
            BufferedImage imageTwo = ImageIO.read(second);
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[] secondRGB = new int[width2 * height2];
            secondRGB = imageTwo.getRGB(0, 0, width2, height2, firstRGB, 0, width2);

            //生成新图片
            int height3 = Math.max(height1, height2);
            int width3 = width1 + width2;
            BufferedImage imageNew = new BufferedImage(width3, height3, BufferedImage.TYPE_INT_RGB);

            //设置左半部分RGB，从（0，0）开始
            imageNew.setRGB(0, 0, width1, height1, firstRGB, 0, width1);
            //设置右半部分RGB，从（width1，0）开始
            imageNew.setRGB(width1, 0, width2, height2, secondRGB, 0, width2);

            //保存图片
            ImageIO.write(imageNew, imageFormat, new File(toPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
