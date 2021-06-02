package zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QRCodeTest {
    /*
    定义二维码的宽高和格式
     */
    private static int WIDTH = 300;
    private static int HEIGHT = 300;
    private static String FORMAT = "png";

    //生产二维码
    public static void generateQRCode(File file, String content) {
        //定义二维码参数
        Map<EncodeHintType, Object> hints = new HashMap<>();

        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//设置编码
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//设置容错等级
        hints.put(EncodeHintType.MARGIN, 2);//设置默认边距

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
            Path path = file.toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, FORMAT, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readQRCode(File file) {
        MultiFormatReader reader = new MultiFormatReader();
        try {
            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = reader.decode(binaryBitmap, hints);
            System.out.println("解析结果：" + result.toString());
            System.out.println("二维码格式：" + result.getBarcodeFormat());
            System.out.println("二维码文本内容：" + result.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateQRCode(new File("F:\\School\\Notebook\\pics\\二维码\\myCode_04.png"), "李皓宇大潮巴");
        readQRCode(new File("F:\\School\\Notebook\\pics\\二维码\\myCode_03.png"));
    }
}
