package pl.tworek.EatingPlanner.recipes.domain.ports.primary;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import pl.tworek.EatingPlanner.configuration.MainTestConfiguration;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.domain.vo.Description;
import pl.tworek.EatingPlanner.recipes.domain.vo.RecipeTitle;

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
    private RecipeService recipeService;

    @BeforeAll
    public static void initTest() throws SQLException {
        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082")
                .start();
    }

    @Test
    public void shouldSaveRecipe() {
        //given
        Recipe recipeToSave = Recipe.builder()
                .name(prepareRecipeTitle())
                .description(prepareRecipeDescription()).build();

        //when
        Recipe savedRecipe = recipeService.save(recipeToSave);

        assertEquals("Test", savedRecipe.getName().getValue());
    }

    private Description prepareRecipeDescription() {
        return new Description("Test content");
    }

    private RecipeTitle prepareRecipeTitle() {
        return new RecipeTitle("Test");
    }

}