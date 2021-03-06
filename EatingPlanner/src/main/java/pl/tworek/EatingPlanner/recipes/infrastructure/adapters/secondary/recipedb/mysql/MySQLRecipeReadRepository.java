package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary.recipedb.mysql.entity.RecipeEntity;

@Repository("recipes.MySQLRecipeRepository")
public interface MySQLRecipeReadRepository extends JpaRepository<RecipeEntity, Long> {

    boolean existsByName(String name);
}
