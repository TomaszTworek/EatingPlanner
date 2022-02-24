package pl.tworek.EatingPlanner.recipes.configuration;

import org.springframework.context.annotation.Configuration;
import pl.tworek.EatingPlanner.recipes.domain.ports.DomainRecipeService;
import pl.tworek.EatingPlanner.recipes.domain.ports.RecipeService;

/**
 * To remove later on:
 * In this class i'll be implementing Bean configuration.Learn how to proper configure a bean.
 */
@Configuration
public class RecipeConfiguration {

    RecipeService recipeService(){
        return new DomainRecipeService();
    }
}
