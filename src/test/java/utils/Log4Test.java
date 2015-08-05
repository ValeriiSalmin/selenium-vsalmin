package utils;

import org.testng.Reporter;
import org.testng.log4testng.Logger;


/**
 * Created by selenium on 05.08.2015.
 */
public class Log4Test {
    
    private static final Logger LOGGER = Logger.getLogger(Log4Test.class);

    private static final String INFO_LOG = "INFO: \"%s\"";
    private static final String ERROR_LOG = "ERROR: \"%s\" !";
    private Log4Test(){
    }

    public static String error(String message){
        LOGGER.error(String.format(ERROR_LOG, message));
        Reporter.log(String.format(ERROR_LOG, message));
        return String.format(ERROR_LOG, message);
    }

    public static String info(String message){
        LOGGER.info(String.format(INFO_LOG,message));
        Reporter.log(String.format(INFO_LOG, message));
        return String.format(INFO_LOG, message);
    }
}
