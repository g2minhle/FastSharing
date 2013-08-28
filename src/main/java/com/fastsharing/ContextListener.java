package com.fastsharing;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		FileDB.cleanDB();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		FileDB.initDB();
	}

}
