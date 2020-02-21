package com.foysal.core.logger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;
public class DemoLogger {

    public static void main(String[] args) {

        // Logger form log manager
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // Default console handler print to  Level.INFO
        // To print all we need to write our customize console  handler
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);

        // Need to stop use parent handler
        // other-wise it will print duplicate message
        // base on default configuration
        logger.setUseParentHandlers(false);

        //Logger default level Level.INFO
        //So we need to change it to print all
        logger.setLevel(Level.ALL);
        // The logs will be generated for all the levels equal to or greater than the logger level.
        // For example if logger level is set to INFO, logs will be generated for INFO, WARNING and SEVERE logging messages.
        // Level.OFF stop logging.............
//        log.setLevel(Level.OFF);
        logger.log(Level.SEVERE, "Indicates some serious failure value 1000");
        logger.log(Level.WARNING, "Potential Problem value 900");
        logger.log(Level.INFO, "General info value 800");
        logger.log(Level.CONFIG, "Configuration info value 700");
        logger.log(Level.FINE, "General developer info value 500");
        logger.log(Level.FINER, "Detailed developer info value 400");
        logger.log(Level.FINEST, "Specialized developer info 300");

    }
}
