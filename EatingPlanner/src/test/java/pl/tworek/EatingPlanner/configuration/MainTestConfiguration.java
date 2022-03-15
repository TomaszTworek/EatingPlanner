package pl.tworek.EatingPlanner.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("pl.tworek.EatingPlanner")
@EntityScan("pl.tworek.EatingPlanner")
@EnableJpaRepositories("pl.tworek.EatingPlanner")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MainTestConfiguration {

}
