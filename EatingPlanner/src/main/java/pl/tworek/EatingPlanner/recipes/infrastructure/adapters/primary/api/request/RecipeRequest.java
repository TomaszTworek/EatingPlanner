package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RecipeRequest {

    private String name;

    private String description;

    private String preparingTime;

    @JsonProperty("recipe_image_photo")
    private RecipeImagePhoto recipeImagePhoto;
}
