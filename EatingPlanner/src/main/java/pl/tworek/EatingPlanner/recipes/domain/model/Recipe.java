package pl.tworek.EatingPlanner.recipes.domain.model;

//TODO: Think, which field could be VO or separate model

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.tworek.EatingPlanner.recipes.domain.enumeration.EatLabel;

import java.util.List;

@Getter
@EqualsAndHashCode
@Builder
@ToString
public class Recipe {

    private final String name;

    private final DishPhoto dishPhoto;

    private final String description;

    private final Integer preparingTime;

    private final Integer toughness;

    private final Integer tastiness;

    private final Integer healthiness;

    private final Integer defaultServing;

    private final Double callPerServing;

    private final List<EatLabel> eatLabels;
}
