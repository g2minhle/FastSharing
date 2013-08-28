package com.fastsharing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.fastsharing.structure.TheFile;

public class FileDB {

	private static int initialUserID;
	private static SessionFactory factory;

	public static void initDB() {
		initialUserID = 1234;
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);

	}

	public static void cleanDB() {
		if (factory != null) {
			factory.close();
		}
		factory = null;
	}

	public static int saveFile(TheFile theFile) {
		boolean notDone = true;
		while (notDone) {
			try {
				Session sec = createSession();
				sec.save(theFile);
				closeSession(sec);
				notDone = false;
			} catch (Exception e) {
				notDone = true;
				e.printStackTrace();
			}
		}
		return theFile.getFileID() + initialUserID;
	}

	private static Session createSession() {
		Session sec = factory.openSession();
		sec.beginTransaction();
		return sec;
	}

	private static void closeSession(Session sec) {
		if (sec != null) {
			sec.getTransaction().commit();
			sec.close();
		}
	}
}
