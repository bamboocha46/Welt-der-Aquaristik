package at.varga.java.welt_der_aquaristik.service;

import java.util.List;

import at.varga.java.welt_der_aquaristik.exception.ServiceException;

import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
import at.varga.java.welt_der_aquaristik.repository.FishTypeInAQRepositoryJPA;

public class FishTypeInAQService {

	private FishTypeInAQRepositoryJPA repository = new FishTypeInAQRepositoryJPA();

	public void addFishTypeInAQ(FishTypeInAQ fishTypeInAQ) throws ServiceException {
		repository.add(fishTypeInAQ);
	}

	public FishTypeInAQ updateFishTypeInAQ(FishTypeInAQ fishTypeInAQ) throws ServiceException {

		return repository.update(fishTypeInAQ);
	}

	public List<FishTypeInAQ> getAllFishTypeInAQ() throws ServiceException {

		List<FishTypeInAQ> fishTypeInAQList = repository.getAll();
		return fishTypeInAQList;

	}

	public void deleteFishTypeInAQ(FishTypeInAQ fishTypeInAQ) throws ServiceException {

		repository.delete(fishTypeInAQ);
	}

}
