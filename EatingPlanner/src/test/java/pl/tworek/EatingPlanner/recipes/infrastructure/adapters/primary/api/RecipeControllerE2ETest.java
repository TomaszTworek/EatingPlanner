package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api;

import com.github.tomakehurst.wiremock.matching.EqualToPattern;
import com.github.tomakehurst.wiremock.matching.StringValuePattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import pl.tworek.EatingPlanner.configuration.MainTestConfiguration;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeRequest;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@AutoConfigureWireMock(port = 0)
@DataJpaTest
@ContextConfiguration(classes = MainTestConfiguration.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class
})
class RecipeControllerE2ETest {

    @Autowired
    private RecipeController recipeController;


    @Test
    public void test(){
//        stubFor(post(urlEqualTo("/recipe")).willReturn(aResponse())
//                .withHeader("Content-Type").withBody("Hello World!"));

        assertThat(this.recipeController.save(new RecipeRequest())).isEqualTo("Hello World!");

    }
}