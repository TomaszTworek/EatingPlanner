package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RecipeImageInformationRequest {

    @JsonProperty("name")
    private String imageName;

    @JsonProperty("size")
    private Long size;

    @JsonProperty("extension")
    private String extension;

}
