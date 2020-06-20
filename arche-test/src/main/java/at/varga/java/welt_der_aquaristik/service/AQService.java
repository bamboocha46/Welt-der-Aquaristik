package at.varga.java.welt_der_aquaristik.service;

import java.util.List;

import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.repository.AQRepositoryJPA;

public class AQService {
	


	private AQRepositoryJPA repository = new AQRepositoryJPA(); 


	public void addAQ(AQ aq) throws ServiceException {
		
		repository.add(aq);

	}


	public AQ updateAQ(AQ aq) throws ServiceException {

		return repository.update(aq);
	}

	public List<AQ> getAllAQ() throws ServiceException {

		List<AQ> aqList = repository.getAll();
		return aqList;

	}

	
	public void deleteAQ(AQ aq) throws ServiceException {
		
		repository.delete(aq);
	}

}
