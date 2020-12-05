package resturant.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "resturant")
@ImportResource("applicationContext.xml")
public class SpringContext {

}
