package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.tworek.EatingPlanner.recipes.domain.model.Recipe;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeImageInformationRequest;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeRequest;

@Mapper(uses = {RecipeImageInformationRequest.class})
public interface RecipeMapper {

    @Mapping(target = "name.value", source = "name")
    @Mapping(target = "description.content", source = "description")
    @Mapping(target = "preparingTime.time", source = "preparingTime")
    @Mapping(target = "recipeImageInformation", source = "recipeImageInformationRequest")
    Recipe map(RecipeRequest recipeRequest);
}
