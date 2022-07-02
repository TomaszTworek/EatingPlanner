package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "recipe_image_data")
@Data
public class RecipeImageInformationEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "size")
    private Long size;

    @Column(name = "extension")
    private String extension;

    @OneToOne(mappedBy = "recipeImageInformationEntity")
    private RecipeEntity recipeEntity;

}
