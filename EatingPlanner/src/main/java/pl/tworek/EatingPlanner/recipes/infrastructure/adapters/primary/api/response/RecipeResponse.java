package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.primary.api.response;

import lombok.Data;
import org.springframework.core.io.Resource;

@Data
public class RecipeResponse {

    private String name;

    private String description;

    private Integer preparingTime;

    private Resource resource;
}
