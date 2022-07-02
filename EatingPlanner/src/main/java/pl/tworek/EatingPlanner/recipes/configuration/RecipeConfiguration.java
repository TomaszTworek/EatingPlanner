package pl.tworek.EatingPlanner.recipes.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.tworek.EatingPlanner.recipes.domain.ports.primary.RecipePort;
import pl.tworek.EatingPlanner.recipes.domain.ports.primary.RecipePortImpl;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.RecipeRepository;
import pl.tworek.EatingPlanner.recipes.domain.service.RecipeService;
import pl.tworek.EatingPlanner.recipes.domain.service.RecipeServiceImpl;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.mapper.RecipeMapper;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.mapper.RecipeMapperImpl;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.mapper.RecipeResponseMapper;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.mapper.RecipeResponseMapperImpl;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.mapper.RecipeEntityMapper;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.MySQLRecipeReadRepository;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.RecipeRepositoryImpl;

/**
 * To remove later on:
 * In this class i'll be implementing Bean configuration.Learn how to proper configure a bean.
 */
@Configuration
public class RecipeConfiguration {

    @Bean
    public RecipePort recipePort(RecipeRepository recipeRepository) {
        return new RecipePortImpl(recipeService(recipeRepository));
    }

    private RecipeService recipeService(RecipeRepository recipeRepository) {
        return new RecipeServiceImpl(recipeRepository);
    }

    @Bean
    public RecipeRepository recipeRepository(MySQLRecipeReadRepository mySQLRecipeReadRepository) {
        return new RecipeRepositoryImpl(mySQLRecipeReadRepository, recipeEntityMapper());
    }

    private RecipeEntityMapper recipeEntityMapper() {
        return Mappers.getMapper(RecipeEntityMapper.class);
    }

    @Bean
    public RecipeMapper recipeMapper() {
        return new RecipeMapperImpl();
    }

    @Bean
    public RecipeResponseMapper recipeResponseMapper() {
        return new RecipeResponseMapperImpl();
    }
}
