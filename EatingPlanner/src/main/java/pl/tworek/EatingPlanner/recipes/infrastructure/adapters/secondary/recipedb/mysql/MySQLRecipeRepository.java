package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeEntity;

@Repository
public interface MySQLRecipeRepository extends JpaRepository<RecipeEntity, Long> {
}
