package nitish.generatePdf.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import nitish.generatePdf.Models.BuyerSeller;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.logging.Logger;

@Service
public class generatorPdfService {
    //private Logger logger= LoggerFactory.getLogger(generatorPdfService.class);
    public ByteArrayInputStream generatePdf(BuyerSeller data) throws Exception{
        //logger.info("Creating");
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        Document doc= new Document();
        PdfWriter.getInstance(doc,out);
        String title="hello";
        doc.open();
        Paragraph paragraph=new Paragraph(title);
        doc.add(paragraph);
        doc.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
}
