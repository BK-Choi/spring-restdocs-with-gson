package foo.boo;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {
		"classpath:applicationContext.xml",
		"classpath:applicationContext-rest.xml",
		"classpath:dispatcher-servlet.xml"})
public class GsonTest {

	@Autowired
	GsonRepository gsonRepository;

	@Autowired
	public RestTemplate restTemplate;

	@Test
	public void gsonTest() {
		// given

		// when
		Model model = gsonRepository.retrieveJson();

		// then
		Assert.assertThat(model.getVar1(), is(1234));
		Assert.assertThat(model.getVar2(), is("1234"));
	}
}