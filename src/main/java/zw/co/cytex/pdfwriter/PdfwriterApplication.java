package zw.co.cytex.pdfwriter;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.text.Image;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;


@SpringBootApplication
public class PdfwriterApplication {
    private static final String FILE_NAME = "/home/schidodo/mos.pdf";

    public static void main(String[] args) {
        SpringApplication.run(PdfwriterApplication.class, args);
        writeUsingIText();
    }

    private static void writeUsingIText() {

        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            Rectangle one = new Rectangle(240,170);
            document.setPageSize(one);
            document.setMargins(2, 2, 2, 2);
            //open
            document.open();

            // Creating an image
            Image img = Image.getInstance("/home/schidodo/Pictures/bank.png");
            img.scaleAbsolute(150f, 50f);
            img.setAlignment(Element.ALIGN_CENTER);
            document.add(img);


            Paragraph p = new Paragraph();
            p.add("This is my paragraph 1");
            p.setAlignment(Element.ALIGN_CENTER);

            document.add(p);


            Paragraph p2 = new Paragraph();
            p2.add("This is my paragraph 2"); //no alignment

            document.add(p2);

            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);

            Font fx = new Font();
            fx.setStyle(Font.NORMAL);
            fx.setSize(4);

            document.add(new Paragraph("This is my paragraph 3", f));

            Paragraph px = new Paragraph();
            px.add("600");
            px.setFont(fx);
            px.setAlignment(Element.ALIGN_RIGHT);

            document.add(px);



            //close
            document.close();

            System.out.println("Done");

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }


}
