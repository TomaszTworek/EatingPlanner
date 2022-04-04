package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipePhotoEntity;

@Repository("recipes.MySQLRecipePhotoRepository")
public interface MySQLRecipePhotoRepository extends JpaRepository<RecipePhotoEntity, Long> {
}
