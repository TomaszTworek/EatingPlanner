package pl.tworek.EatingPlanner.recipes.domain.model;

import lombok.Value;

@Value
public class RecipeImageInformation {

    String imageName;

    Long size;

    String extension;
}
