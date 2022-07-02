package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.tworek.EatingPlanner.recipes.domain.model.RecipeImageInformation;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeImageInformationEntity;

@Mapper
public interface RecipeImageInformationEntityMapper {

    @Mapping(target = "title", source = "imageName")
    RecipeImageInformationEntity map(RecipeImageInformation recipeImageInformation);

    @Mapping(target = "imageName", source = "title")
    RecipeImageInformation map(RecipeImageInformationEntity recipeImageInformationEntity);
}
