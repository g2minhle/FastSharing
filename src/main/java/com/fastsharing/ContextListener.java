package com.fastsharing;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Context listener to do job when the application is started or stopped
 * 
 * @author g2minhle
 * 
 */
public class ContextListener implements ServletContextListener {

	/**
	 * Do clean up jobs when the application is stooped
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// Clean up the database
		FileDB.cleanDB();
	}

	/**
	 * Do initialization jobs when the application started
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// Initialize database
		FileDB.initDB();
	}

}
