package tutorial.chapter01;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;

public class RickAstley {
    public static final String DEST = "results/chapter01/rick_astley.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new RickAstley().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {

        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        document.add(new Paragraph("iText is:").setFont(font));

        List list = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(font);
        list.add(new ListItem("Pedro"))
                .add(new ListItem("Pedro"))
                .add(new ListItem("Pedro"))
                .add(new ListItem("Pedro"))
                .add(new ListItem("Pedro"))
                .add(new ListItem("Pedro"))
                .add(new ListItem("Pedro"));

        document.add(list);
        document.close();
    }
}
