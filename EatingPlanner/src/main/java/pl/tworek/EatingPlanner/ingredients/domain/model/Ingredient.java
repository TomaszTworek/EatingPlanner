package pl.tworek.EatingPlanner.ingredients.domain.model;


import lombok.Builder;
import lombok.Value;
import pl.tworek.EatingPlanner.recipes.domain.vo.IngredientId;

@Builder
@Value
public class Ingredient {

    IngredientId ingredientId;
}
