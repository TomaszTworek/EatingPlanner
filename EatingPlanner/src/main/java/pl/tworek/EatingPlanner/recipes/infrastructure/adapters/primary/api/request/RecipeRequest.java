package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RecipeRequest {

    private String name;

    private String description;

    private String preparingTime;

    private RecipeImageInformationRequest recipeImageInformationRequest;
}
