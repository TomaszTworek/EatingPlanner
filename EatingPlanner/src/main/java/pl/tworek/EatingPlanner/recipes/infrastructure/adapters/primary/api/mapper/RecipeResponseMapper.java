package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.response.RecipeResponse;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface RecipeResponseMapper {

    @Mapping(target = "name", source = "name.value")
    @Mapping(target = "description", source = "description.content")
    @Mapping(target = "preparingTime", source = "preparingTime.time")
    @Mapping(target = "resource", ignore = true)
    RecipeResponse map(Recipe recipe);

    default List<RecipeResponse> map(List<Recipe> allRecipes) {
        List<RecipeResponse> mappedRecipeResponses = new ArrayList<>();
        for (Recipe recipe : allRecipes) {
            mappedRecipeResponses.add(map(recipe));
        }
        return mappedRecipeResponses;
    }
}
