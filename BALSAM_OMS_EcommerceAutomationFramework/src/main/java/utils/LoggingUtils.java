package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingUtils.class);

    public static void logInfo(String message) {
        LOGGER.info(message);
    }

    public static void logError(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }
}
