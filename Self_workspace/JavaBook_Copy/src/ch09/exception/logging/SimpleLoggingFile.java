package ch09.exception.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleLoggingFile {

	private final static Logger logger = Logger.getLogger(SimpleLoggingFile.class.getName());
	
	public static void main(String[] args) throws SecurityException, IOException {
		FileHandler fhandler = new FileHandler("mylog_%g.log");
		logger.addHandler(fhandler);
		logger.log(Level.INFO,"info log");
		logger.info("method type info log");
		logger.warning("method type warning log");
		logger.severe("method type severe log");
	}

}
