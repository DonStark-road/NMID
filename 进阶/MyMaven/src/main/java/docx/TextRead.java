package docx;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class TextRead {

    public static void main(String[] args) throws Exception {
        readDocx();
    }

    public static void readDocx() throws Exception {
        InputStream is = new FileInputStream("test.docx");
        XWPFDocument xwpf = new XWPFDocument(is);

        List<IBodyElement> ibs = xwpf.getBodyElements();
        for (IBodyElement ib : ibs) {
            BodyElementType bet = ib.getElementType();
            if (bet == BodyElementType.TABLE) {
                //表格
                System.out.println("table：" + ib.getPart());
            } else {
                //段落
                XWPFParagraph para = (XWPFParagraph) ib;
                System.out.println("It's a new paragraph...The indention is " + para.getFirstLineIndent() + "，");

                List<XWPFRun> res = para.getRuns();
                //System.out.println("run");
                if (res.size() <= 0) {
                    System.out.println("Empty Line ！");
                }
                for (XWPFRun re : res) {
                    if (re.text() == null || re.text().length() <= 0) {
                        if (re.getEmbeddedPictures().size() > 0) {
                            System.out.println("image***" + re.getEmbeddedPictures());
                        } else {
                            System.out.println("objects：" + re.getCTR().getObjectList().toString());
                            if (re.getCTR().xmlText().indexOf("instrText") > 0) {
                                System.out.println("there is an equation field");
                            }
                        }
                    } else {
                        System.out.println("===" + re.getCharacterSpacing() + re.text());
                    }
                }
            }
        }
        is.close();
    }
}
