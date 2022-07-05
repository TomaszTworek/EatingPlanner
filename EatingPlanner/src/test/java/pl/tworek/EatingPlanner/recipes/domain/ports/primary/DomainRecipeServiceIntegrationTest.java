package pl.tworek.EatingPlanner.recipes.domain.ports.primary;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import pl.tworek.EatingPlanner.configuration.MainTestConfiguration;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.RecipeController;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = MainTestConfiguration.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class
})
class DomainRecipeServiceIntegrationTest {

    @Autowired
    private RecipeController recipeController;

    @BeforeAll
    public static void initTest() throws SQLException {
        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082")
                .start();
    }

//    @Test
//    public void shouldSaveRecipe() {
//        //given
//        RecipeRequest recipeToSave = RecipeRequest.builder()
//                .name("Test")
//                .description("Test content").build();
//
//        //when
//        RecipeResponse savedRecipe = recipeController.save(recipeToSave);
//
//        assertEquals("Test", savedRecipe.getName());
//    }


}