package at.varga.java.welt_der_aquaristik.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;

import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.FishType;

public interface IFishTypeRepository {
	
	public void add(FishType fishType) throws ServiceException;
	
	public FishType update(FishType fishType) throws ServiceException;

	public List<FishType> getAll() throws ServiceException;

	public Optional<FishType> get(long id) throws ServiceException;

	public void delete(FishType fishType) throws ServiceException;

}
