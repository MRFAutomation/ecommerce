package com.utils.pkg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

	// Get Logger Object
	public Logger log() {
		// Logic to get the name of current class
		// Thread.currentThread().getStackTrace()[2].getClassName()
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}

}
