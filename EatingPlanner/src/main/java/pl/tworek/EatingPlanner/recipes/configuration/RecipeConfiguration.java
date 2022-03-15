package pl.tworek.EatingPlanner.recipes.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.tworek.EatingPlanner.recipes.domain.ports.primary.DomainRecipeService;
import pl.tworek.EatingPlanner.recipes.domain.ports.primary.RecipeService;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.RecipeRepository;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.mapper.RecipeMapper;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.RecipeApiService;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.MySQLRecipeRepository;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.RecipeRepositoryImpl;

/**
 * To remove later on:
 * In this class i'll be implementing Bean configuration.Learn how to proper configure a bean.
 */
@Configuration
public class RecipeConfiguration {

    @Bean
    public RecipeApiService recipeApiService(@Qualifier("recipes.MySQLRecipeRepository") MySQLRecipeRepository mySQLRecipeRepository) {
        return new RecipeApiService(recipeService(mySQLRecipeRepository), recipeMapper());
    }

    @Bean
    public RecipeService recipeService(MySQLRecipeRepository mySQLRecipeRepository) {
        return new DomainRecipeService(recipeRepository(mySQLRecipeRepository));
    }

    public RecipeRepository recipeRepository(MySQLRecipeRepository mySQLRecipeRepository) {
        return new RecipeRepositoryImpl(mySQLRecipeRepository, recipeMapper());
    }


    private RecipeMapper recipeMapper() {
        return Mappers.getMapper(RecipeMapper.class);
    }

}
