package com.foysal.core.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class LoggingInFile {
    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        try {
            logManager.readConfiguration(new FileInputStream("loggerCustom.properties"));
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        Logger logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.ALL);
        try{
            Handler fileHandler = new FileHandler("C:\\Users\\Foysal Ahmmed\\temp\\",2000000,10);
            logger.addHandler(fileHandler);
            //To stop console writing
            logger.setUseParentHandlers(false);
            // By default it will write xml format. We set our format simple format in loggerCustom.properties file
            for(int i=0; i<10; i++){
                logger.log(Level.INFO, "Message number: " + i);
            }
        } catch(SecurityException | IOException e){
            e.printStackTrace();
        }
    }
}
