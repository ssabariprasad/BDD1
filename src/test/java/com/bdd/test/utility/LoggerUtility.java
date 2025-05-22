package com.bdd.test.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
public static <T> Logger getLogger(Class<T> clazz)
{
	return LogManager.getLogger(clazz);
  
}

}
