package hello;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloProject1Controller {   
	
   @Autowired
   RestTemplate restTemplate;

   @RequestMapping(value = "/helloProject1")
   public String hello() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      
      return restTemplate.exchange("http://web1-svc:8080/hello", HttpMethod.GET, entity, String.class).getBody();
   }

}
