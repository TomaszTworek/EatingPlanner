package pl.tworek.EatingPlanner.recipes.infrastructure.adapters.secondary;

import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.Logger;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.LoggerFactory;
import pl.tworek.EatingPlanner.recipes.infrastructure.adapters.LoggerImpl;

public class LoggerFactoryImpl implements LoggerFactory {
    @Override
    public Logger getLogger(Class<?> clazz) {
        return new LoggerImpl(org.slf4j.LoggerFactory.getLogger(clazz));
    }

    @Override
    public Logger getLogger(String name) {
        return new LoggerImpl(org.slf4j.LoggerFactory.getLogger(name));
    }
}
