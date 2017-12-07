package be.quatrefeuilles.webshop;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.Cleanup;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;

@RunWith(SpringRunner.class)
//@SpringBootTest
@CommonsLog
public class WebshopApplicationTests {

//	@Autowired
//	private CommandRepository commandRepository;
//
//	@Autowired
//	private UserRepository userRepository;

//	@Autowired
//    private S3Service s3Service;

//	@Test
//	public void contextLoads() {
//	}

//    @Test
//    public void findAllCommands() {
//        commandRepository.findAll().stream().forEach(log::info);
//    }
//
//    @Test
//    public void findPayedCommands() {
//        commandRepository.findPayedCommands().stream().forEach(c -> log.info(c.currentStatus()));
//    }

    @Test
    public void uploadFile() throws Exception {
        @Cleanup InputStream is = this.getClass().getClassLoader().getResourceAsStream("pdf.pdf");
        AmazonS3 amazonS3Client = AmazonS3Client.builder()
                .withCredentials(new ProfileCredentialsProvider())
                .withRegion(Regions.EU_CENTRAL_1)
                .build();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(is.available());

        amazonS3Client.putObject(new PutObjectRequest("fbrcls", "pdf", is, objectMetadata));

        amazonS3Client.deleteObject("fbrcls", "pdf");
    }

    @Test
    public void countPages() throws Exception {
        @Cleanup InputStream is = this.getClass().getClassLoader().getResourceAsStream("pdf.pdf");
        PDDocument pdf = PDDocument.load(is);
        log.info(pdf.getNumberOfPages());
        PDFPageable pageable = new PDFPageable(pdf);
        log.info(pageable.getNumberOfPages());
        log.info(Math.round(pageable.getPageFormat(1).getPaper().getHeight() / 72 * 2.54 * 10.0) / 10.0);
        log.info(Math.round(pageable.getPageFormat(1).getPaper().getWidth() / 72 * 2.54 * 10.0) / 10.0);
    }

}