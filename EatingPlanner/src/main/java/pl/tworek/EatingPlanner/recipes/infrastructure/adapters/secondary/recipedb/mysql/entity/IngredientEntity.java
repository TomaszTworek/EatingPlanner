package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IngredientEntity {

    @Id
    private Long id;
}
