package itd.secondhandmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SecondHandMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondHandMallApplication.class, args);
        System.out.println("swagger： "+ String.format("http://:8080/swagger-ui.html"));
        System.out.println();
    }

}
