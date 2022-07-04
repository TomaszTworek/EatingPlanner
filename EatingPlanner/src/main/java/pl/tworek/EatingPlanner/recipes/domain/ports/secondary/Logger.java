package pl.tworek.EatingPlanner.recipes.domain.ports.secondary;

public interface Logger {
    void warn(String format, Object... arguments);
}
