package pl.tworek.EatingPlanner.recipes.domain.exceptions;

import pl.tworek.EatingPlanner.recipes.domain.vo.RecipeName;

public class InvalidRecipeName extends RuntimeException {

    public InvalidRecipeName(RecipeName name) {
        super(String.format("Recipe with name: \"%s\" already exists.", name.getValue()));
    }
}
