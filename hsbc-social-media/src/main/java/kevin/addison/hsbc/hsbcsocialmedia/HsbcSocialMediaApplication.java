package kevin.addison.hsbc.hsbcsocialmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "kevin.addison.hsbc.hsbcsocialmedia")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class HsbcSocialMediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HsbcSocialMediaApplication.class, args);
    }
}
