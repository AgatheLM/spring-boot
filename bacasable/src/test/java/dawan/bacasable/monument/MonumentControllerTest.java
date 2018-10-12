package dawan.bacasable.monument;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import dawan.bacasable.Main;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Main.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class MonumentControllerTest {
	
	@Autowired
	MonumentRepository monumentRepository;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	@Before
	public void emptyDataBase() {
		monumentRepository.deleteAll();
	}
	
	@Test
	public void test1() {
		
	}

}
