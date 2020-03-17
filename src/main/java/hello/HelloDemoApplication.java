package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
public class HelloDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloDemoApplication.class, args);
	}

}
@RestController
class HelloRestController{
	@RequestMapping("/index/{name}")
	public String getName(@PathVariable(value = "name") String name){
		String response = "Hai " + name + "VISHAM theerunno";
		return response;
	}


}
