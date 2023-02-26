package nitish.generatePdf.Controller;

import nitish.generatePdf.Models.BuyerSeller;
import nitish.generatePdf.Service.generatorPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/pdf")
public class pdfController {
    @Autowired
    generatorPdfService generatorPdfService;

    @GetMapping("/generator")
    public ResponseEntity<InputStreamResource> generatePdf(@RequestBody BuyerSeller pdfData)throws Exception {
        ByteArrayInputStream bit=generatorPdfService.generatePdf(pdfData);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-disposition","inline;file=sample.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bit));

    }
}
