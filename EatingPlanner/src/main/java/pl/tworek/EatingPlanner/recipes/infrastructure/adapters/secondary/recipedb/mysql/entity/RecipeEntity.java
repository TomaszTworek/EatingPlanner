package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity;

import lombok.Data;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.enumeration.EatLabel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "recipe")
public class RecipeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Transient
    private Long version;

    @Transient
    private Timestamp createdAt;

    @Transient
    private Timestamp updatedAt;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "recipe_image_data_id", referencedColumnName = "id")

    private RecipePhotoEntity recipePhotoEntity;

    @Column(name = "description")
    private String description;

    @Column(name = "toughness")
    private Integer toughness;

    @Column(name = "tastiness")
    private Integer tastiness;

    @Column(name = "healthiness")
    private Integer healthiness;

    @Column(name = "default_servings")
    private Integer defaultServings;

    @Column(name = "cal_per_serving")
    private Double calPerServing;

    @Column(name = "prepare_time")
    private Integer preparingTime;

    @Transient
    private List<EatLabel> eatLabel;

    //@ManyToMany(from s42 project -example)
    @Transient
    private List<IngredientEntity> ingredientEntityList;
}
