package foo.boo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class GsonRepository {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://localhost:8080/give-me-json";

	public Model retrieveJson() {
		try {
			ResponseEntity<Model> entity = restTemplate.getForEntity(url, Model.class);
			return entity.getBody();
		} catch (HttpClientErrorException e) {
			return null;
		}
	}
}
