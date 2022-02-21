package pl.tworek.EatingPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EatingPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EatingPlannerApplication.class, args);
    }

}
