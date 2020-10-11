package com.js;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.js.research.Research;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Research.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerIntegrationTest {
    
    @LocalServerPort
    private int port;

    @Test
    public void libraryShouldBeAvailable() {
	RestTemplate template = new RestTemplate();

	ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/lib/vue.js", String.class);
	
	assertEquals(HttpStatus.OK, response.getStatusCode());
	assertTrue(response.getBody().contains("Vue.js"));

    }
}
