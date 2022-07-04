package pl.tworek.EatingPlanner.recipes.infrastructure.adapters;

import lombok.RequiredArgsConstructor;
import pl.tworek.EatingPlanner.recipes.domain.ports.secondary.Logger;

@RequiredArgsConstructor
public class LoggerImpl implements Logger {

    private final org.slf4j.Logger logger;

    @Override
    public void warn(String format, Object... arguments) {
        logger.warn(format, arguments);
    }
}
