package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RecipeRequest {

    private String name;

    private String description;

    @JsonProperty("recipe_image_photo")
    private RecipeImagePhoto recipeImagePhoto;
}
