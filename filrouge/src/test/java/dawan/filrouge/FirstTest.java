package dawan.filrouge;


import static org.junit.Assert.assertEquals;

import javax.xml.ws.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import dawan.filrouge.modele.Format;
import dawan.filrouge.repository.FormatRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Main.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class FirstTest {
	
	@Autowired
	FormatRepository formatRepository;
	
	private RestTemplate restTemplate = new RestTemplate();
	String url ="http://localhost:9000";
	
	
	@Before
	public void emptyDataBase() {
		formatRepository.deleteAll();
	}
	
	@Test
	public void test1() {
		Format format = new Format();
		format.setNom("MEDIUM");
		format.setMimeType("application/png");
		format.setExtension(".png");
		format.putPropriete("resize", "50x50");
		formatRepository.save(format);
		
		ResponseEntity<Format> reponse = restTemplate.getForEntity(url+"/format/MEDIUM", Format.class);
		
		assertEquals(200,reponse.getStatusCode().value());
		assertEquals(".png",reponse.getBody().getExtension());
		assertEquals("50x50",reponse.getBody().getProprietes().get("resize"));
	}
	
	
	@Test(expected=HttpClientErrorException.class)
	public void test2() {
		Format format = new Format();
		format.setNom("MEDIUM");
		format.setMimeType("application/png");
		format.setExtension(".png");
		format.putPropriete("resize", "50x50");
		formatRepository.save(format);
		
		ResponseEntity<Format> reponse1 = restTemplate.postForEntity(url+"/format/MEDIUM",format, Format.class);
		assertEquals("200",reponse1.getStatusCode().value());
		
		restTemplate.postForEntity(url+"/format/MEDIUM",format, Format.class);
		

	}
	


}
