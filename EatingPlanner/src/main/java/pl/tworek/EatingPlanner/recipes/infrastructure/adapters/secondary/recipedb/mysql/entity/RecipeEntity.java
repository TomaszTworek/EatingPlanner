package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity;

import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.enumeration.EatLabel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class RecipeEntity {

    @Id
    private Long id;

    private Long version;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String name;

    private DishPhotoEntity dishPhotoEntity;

    private String description;

    private Integer toughness;

    private Integer tastiness;

    private Integer healthiness;

    private Integer defaultServings;

    private Double calPerServing;

    private List<EatLabel> eatLabel;
    //@ManyToMany(from s42 project -example)
    private List<IngredientEntity> ingredientEntityList;
}
