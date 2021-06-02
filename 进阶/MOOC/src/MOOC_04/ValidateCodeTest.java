package MOOC_04;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ValidateCodeTest {
    static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q'
            , 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'};

    static int charNum = codeSequence.length;

    public static void main(String[] args) throws IOException {
        generateCode("F:/School/Notebook/pics/RandomCode/rand_code_1.jpg");
    }

    public static void generateCode(String filePath) throws IOException {
        //定义验证码图片框
        int width = 80;
        int height = 32;
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //定义图片上的图形和干扰线
        Graphics2D gd = buffImg.createGraphics();
        gd.setColor(Color.LIGHT_GRAY);      //图像为浅灰色
        gd.fillRect(0, 0, width, height);
        gd.setColor(Color.BLACK);           //画边框
        gd.drawRect(0, 0, width - 1, height - 1);
        //随机产生16条灰色干扰线，使图像中认证码不易识别
        gd.setColor(Color.GRAY);
        //创建一个随机数生成器类，用于随机产生干扰线
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            gd.drawLine(x, y, x + x1, y + y1);
        }

        //计算字的坐标位置
        int codeCount = 4;//字符个数
        int fontHeight;//字体高度
        int codeX;//第一个字符的X坐标，因为后面的字符坐标依次递增，所以他们的x轴值是codeX的
        int codeY;//验证字符的Y坐标，因为并排所以一致
        //width - 4 除去左右多余的位置，使验证码显示更集中
        //codeCount + 1等比分配显示的宽度，包括左右两边的空格
        codeX = (width - 4) / (codeCount + 1);
        fontHeight = height - 10;
        codeY = height - 7;

        //创建字体，字体大小依图片高度决定
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
        gd.setFont(font);

        //随机产生codeCount数字的验证码
        for (int i = 0; i < codeCount; i++) {
            //每次随机拿一个字母，赋予随机的颜色
            String strRand = String.valueOf(codeSequence[random.nextInt(charNum)]);
            int red = random.nextInt(255);
            int green = random.nextInt(255);
            int blue = random.nextInt(255);
            gd.setColor(new Color(red, green, blue));
            gd.drawString(strRand, (i + 1) * codeX, codeY);
        }
        ImageIO.write(buffImg, "jpg", new File(filePath));
    }
}
