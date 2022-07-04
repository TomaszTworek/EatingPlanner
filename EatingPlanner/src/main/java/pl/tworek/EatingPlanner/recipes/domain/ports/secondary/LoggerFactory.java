package pl.tworek.EatingPlanner.recipes.domain.ports.secondary;

public interface LoggerFactory {

    Logger getLogger(Class<?> clazz);

    Logger getLogger(String name);
}
