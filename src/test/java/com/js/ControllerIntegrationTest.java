package com.js;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.js.research.Research;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Research.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerIntegrationTest {
    
    @LocalServerPort
    private int port;
    private static TestRestTemplate template;

    @BeforeClass
    public static void init() {
	template = new TestRestTemplate();
    }
    @Test
    public void libraryShouldBeAvailable() {
	ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/lib/vue.js", String.class);
	
	assertEquals(HttpStatus.OK, response.getStatusCode());
	assertTrue(response.getBody().contains("Vue.js"));
    }

    @Test
    public void applicationShouldBeServed() {
	ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/", String.class);
	
	assertEquals(HttpStatus.OK, response.getStatusCode());
	assertTrue(response.getBody().contains("html"));
    }
    
    @Test
    public void dataShouldBePosted() {
	HttpHeaders headers = new HttpHeaders(); 
	headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
	HttpEntity<String> request = new HttpEntity<String>("{'message':'Hello!'}", headers);
	
	ResponseEntity<Void> response = template.exchange("http://localhost:" + port + "/api/store", HttpMethod.POST, request, Void.class);
	
	assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    
}
