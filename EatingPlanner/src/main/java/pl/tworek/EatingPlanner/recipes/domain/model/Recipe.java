package pl.tworek.EatingPlanner.recipes.domain.model;

//TODO: Think, which field could be VO or separate model

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
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
@Getter
@EqualsAndHashCode
@Builder
@ToString
public class Recipe {

    private final RecipeId id;

    private final RecipeTitle name;

    private final DishPhoto dishPhoto;

    private final Description description;

    private final PreparingTime preparingTime;

    private final Toughness toughness;

    private final Tastiness tastiness;

    private final Healthiness healthiness;

    private final DefaultServings defaultServing;

    private final CalloriesPerServing callPerServing;

    private final List<EatLabel> eatLabels;

    private final List<Ingredient> ingredients;
}
