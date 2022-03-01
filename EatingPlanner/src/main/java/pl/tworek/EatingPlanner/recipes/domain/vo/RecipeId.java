package pl.tworek.EatingPlanner.recipes.domain.vo;

import lombok.NonNull;
import lombok.Value;


@Value
public class RecipeId {

    @NonNull
    Long id;
}
