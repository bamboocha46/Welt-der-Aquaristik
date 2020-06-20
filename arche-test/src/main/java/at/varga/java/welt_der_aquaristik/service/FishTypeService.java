package at.varga.java.welt_der_aquaristik.service;

import java.util.List;

import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.repository.FishTypeRepositoryJPA;

public class FishTypeService {
	
	private FishTypeRepositoryJPA repository = new FishTypeRepositoryJPA();

public void addFishType(FishType fishType) throws ServiceException {
		
		repository.add(fishType);

	}


	public FishType updateFishType(FishType fishType) throws ServiceException {

		return repository.update(fishType);
	}

	public List<FishType> getAllFishType() throws ServiceException {

		List<FishType> fishTypeList = repository.getAll();
		return fishTypeList;

	}

	
	public void deleteFishType(FishType fishType) throws ServiceException {
		
		repository.delete(fishType);
	}
}
