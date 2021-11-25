package Logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class logsClass {
	
	public static Logger log;
	
	public static void logging() {
		
		org.apache.logging.log4j.Logger log = LogManager.getLogger(logsClass.class.getName());
		
	}

	
	//Returns the name of the entity (class, interface, array class,primitive type, or void) represented by this Class object
	
	
	
}
