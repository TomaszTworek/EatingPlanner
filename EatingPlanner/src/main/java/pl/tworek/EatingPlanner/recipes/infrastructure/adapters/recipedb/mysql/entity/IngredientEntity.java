package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.recipedb.mysql.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IngredientEntity {

    @Id
    private Long id;
}
