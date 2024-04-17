package tutorial.chapter01;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;


import java.io.File;
import java.io.IOException;


public class QuickBrownFox {

    public static final String DOG = "src/main/resources/img/dog.jpg";
    public static final String FOX = "src/main/resources/img/fox.jpg";
    public static final String DEST = "results/chapter01/quick_brown_fox.pdf";

    public static void main(String[] args) throws IOException {
        File file =new File(DEST);
        file.getParentFile().mkdirs();
        new QuickBrownFox().createPdf(DEST);
    }

    private void createPdf(String dest) throws IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        Image fox = new Image(ImageDataFactory.create(FOX));
        Image dog = new Image (ImageDataFactory.create(DOG));
        Paragraph p = new Paragraph("The quick brown")
                .add(fox)
                .add(" jumps over the lazy")
                .add(dog);

        document.add(p);
        document.close();
     }
}
