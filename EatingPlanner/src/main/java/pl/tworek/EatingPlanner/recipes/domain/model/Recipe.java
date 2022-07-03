package pl.tworek.EatingPlanner.recipes.domain.model;


import lombok.Builder;
import lombok.Value;
import pl.tworek.EatingPlanner.ingredients.domain.model.Ingredient;
import pl.tworek.EatingPlanner.recipes.domain.enumeration.EatLabel;
import pl.tworek.EatingPlanner.recipes.domain.vo.*;

import java.util.List;

/**
 * What about relation between oder objects? - Check this in project.
 * What about ingredient relationship
 * Think which one are VO: All of those whichare no objects like DishPhoto or Ingredients. i think
 *
 * Value object are when identity does not matters. When we change value of an object destroy and object and create the new one
 * It does not matters for VO bout an identity. Equals would return true" as long as objets properties are identical.
 *
 * Changing some attribute of an entity like Customer doesnt destroy the customer, its mutable.
 */
@Value
@Builder
public class Recipe {

    RecipeId id;

    RecipeTitle name;

    RecipeImageInformation recipeImageInformation;

    Description description;

    PreparingTime preparingTime;

    Toughness toughness;

    Tastiness tastiness;

    Healthiness healthiness;

    DefaultServings defaultServing;

    CaloriesPerServing callPerServing;

    List<EatLabel> eatLabels;

    List<Ingredient> ingredients;
}
