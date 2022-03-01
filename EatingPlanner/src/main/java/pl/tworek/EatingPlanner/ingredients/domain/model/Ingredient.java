package pl.tworek.EatingPlanner.ingredients.domain.model;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.tworek.EatingPlanner.recipes.domain.vo.IngredientId;

@Getter
@EqualsAndHashCode
@Builder
@ToString
public class Ingredient {

    private IngredientId ingredientId;
}
