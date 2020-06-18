package at.varga.java.welt_der_aquaristik.service;

import java.util.List;

import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.repository.AQRepositoryJPA;

public class AQService {
	
//	public static final String TABLE_NAME = "Aquarium";
//	private static final String DB_NAME = "~/DB/photoDB";
//	private static final String DATABASE_CONNECTION_URL = "jdbc:h2:" + DB_NAME
//			+ ";create=true;user=jprie;password=test";

//	private static final String QUERY_CREATE_PHOTO_TABLE = "CREATE TABLE Photo ("
//			+ "id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), url VARCHAR(255), "
//			+ "photographer INTEGER, date DATE, location VARCHAR(255));";

	private AQRepositoryJPA repository = new AQRepositoryJPA(); 
//
//	public void initDatabase() {
//
////		System.out.println("************************ Init db");
//		try (Connection con = DriverManager.getConnection(DATABASE_CONNECTION_URL);
//				Statement stmt = con.createStatement();) {
//
//			System.out.println("Connection established");
//
//			// if table does not exist create PHOTO table
//			if (!con.getMetaData().getTables(null, null, TABLE_NAME, null).next()) {
//				stmt.execute(QUERY_CREATE_PHOTO_TABLE);
//
//				System.out.println("Created table: " + TABLE_NAME);
//			}
//			
//			// create Repository
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.err.println("FATAL ERROR: Could not create database");
//		}
//
//	}

	public void add(AQ aq) throws ServiceException {
		
		repository.add(aq);

	}


	public AQ update(AQ aq) throws ServiceException {

		return repository.update(aq);
	}

	public List<AQ> getAll() throws ServiceException {

		List<AQ> aqList = repository.getAll();
		return aqList;

	}

	
	public void delete(AQ aq) throws ServiceException {
		
		repository.delete(aq);
	}

}
