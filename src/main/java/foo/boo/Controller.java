package foo.boo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@RequestMapping ("/give-me-json")
	public Model giveMeJson() {
		return new Model(1234, "1234");
	}
}
