package com.fastsharing;

import java.util.ArrayList;

import org.hibernate.Query;
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

	private static int processID(String fileID) {
		try {
			return Integer.parseInt(fileID) - initialUserID;
		} catch (Exception e) {
			// Not a number
			return -1;
		}
	}

	public static boolean hasID(String fileID) {
		int fileCount = 0;
		Session sec = createSession();
		try {
			String sql = "select count(*) from TheFile where fileID = :fileID";
			Query query = sec.createQuery(sql);
			query.setParameter("fileID", processID(fileID));
			fileCount = Integer.parseInt(query.list().get(0).toString());
		} catch (Exception e) {
			closeSession(sec);
			return false;
		}
		closeSession(sec);
		return (fileCount > 0);
	}

	public static String getFileName(String fileID) {
		String fileName;
		Session sec = createSession();
		try {
			String sql = "select fileName from TheFile where fileID = :fileID";
			Query query = sec.createQuery(sql);
			query.setParameter("fileID", processID(fileID));
			fileName = query.list().get(0).toString();
		} catch (Exception e) {
			closeSession(sec);
			return "";
		}
		closeSession(sec);
		return fileName;
	}

	public static TheFile getFile(String fileID) {
		TheFile theFile;
		Session sec = createSession();
		try {
			String sql = "from TheFile where fileID = :fileID";
			Query query = sec.createQuery(sql);
			query.setParameter("fileID", processID(fileID));
			ArrayList<TheFile> result = new ArrayList<TheFile>();
			result.addAll(query.list());
			theFile = result.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			closeSession(sec);
			return null;
		}
		closeSession(sec);
		return theFile;
	}
}
