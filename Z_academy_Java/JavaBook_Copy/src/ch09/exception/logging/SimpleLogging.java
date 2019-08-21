package ch09.exception.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleLogging {
	private final static Logger logger = Logger.getLogger(SimpleLogging.class.getName());
	
	public static void main(String[] args) {
		
		System.out.println(SimpleLogging.class.getClass());
		System.out.println(SimpleLogging.class.getName());
		
		logger.log(Level.INFO,"info log");
		logger.info("method type info log");
		logger.warning("method type warning log");
		logger.severe("method type severe log");
//		logger.addHandler("¹¹³ÄÀÌ°Ç");
	}

}
