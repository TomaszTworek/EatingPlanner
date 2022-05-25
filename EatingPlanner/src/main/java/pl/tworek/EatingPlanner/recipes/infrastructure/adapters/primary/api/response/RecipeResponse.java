package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecipeResponse {

    private String name;

    private String description;

    private Integer preparingTime;

    @JsonProperty(namespace = "recipe_image_photo")
    private RecipeImageResponse recipeImageResponse;
}
