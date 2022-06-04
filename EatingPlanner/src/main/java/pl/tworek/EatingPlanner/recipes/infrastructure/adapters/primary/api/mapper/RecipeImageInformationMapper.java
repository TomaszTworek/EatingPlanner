package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.mapper;

import org.mapstruct.Mapper;
import pl.tworek.EatingPlanner.recipes.domain.model.RecipeImageInformation;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request.RecipeImageInformationRequest;

@Mapper
public interface RecipeImageInformationMapper {

    RecipeImageInformation map(RecipeImageInformationRequest recipeImageInformationRequest);
}
