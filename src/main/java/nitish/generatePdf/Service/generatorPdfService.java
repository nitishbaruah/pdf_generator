package nitish.generatePdf.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import nitish.generatePdf.Models.BuyerSeller;
import nitish.generatePdf.Models.item;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class generatorPdfService {
    //private Logger logger= LoggerFactory.getLogger(generatorPdfService.class);
    public ByteArrayInputStream generatePdf(BuyerSeller data) throws Exception{
        //logger.info("Creating");
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document doc = new Document(pdfDoc);
        // String title="hello";

        //Paragraph paragraph=new Paragraph(title);
        //doc.add(paragraph);
        float [] pointColumnWidths = {150F, 150F, 150F,150F};
        Table table = new Table(pointColumnWidths);
        table.addCell(new Cell(0,2).add("Seller:\n"+
                                                        data.getSeller()+"\n" +
                                                        data.getSellerAddress()+"\n"+
                                                        "GSTIN: "+data.getSellerGstin()).setMargins(10F,10F,10F,25F));
        table.addCell(new Cell(0,2).add("Buyer:\n"+
                data.getBuyer()+"\n" +
                data.getBuyerAddress()+"\n"+
                "GSTIN: "+data.getBuyerGstin()).setMargins(10F,10F,10F,25F));
        table.addCell(new Cell().add("Item").setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("Quantity").setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("Rate").setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("Amount").setTextAlignment(TextAlignment.CENTER));
        List<item> itemsList=data.getItems();
        for(int i=0;i<itemsList.size();i++){
            String rate=String.format("%.2f",itemsList.get(i).getRate());
            String amount=String.format("%.2f",itemsList.get(i).getAmount());
            table.addCell(new Cell().add(itemsList.get(i).getName()).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(itemsList.get(i).getQuantity()).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(rate).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(amount).setTextAlignment(TextAlignment.CENTER));
        }
        table.addCell(new Cell(0,4).add("\n"+"\n"+"\n"+"\n"));

        // Adding Table to document
        doc.add(table);
        doc.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
}
