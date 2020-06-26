/**
 * 
 */
package at.varga.java.welt_der_aquaristik.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;

import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;

/**
 * @author eszte
 *
 */
public interface IFishTypeInAQRepository {

	public void add(FishTypeInAQ fishTypeInAQ) throws ServiceException;

	public FishTypeInAQ update(FishTypeInAQ fishTypeInAQ) throws ServiceException;

	public List<FishTypeInAQ> getAll() throws ServiceException;

	public Optional<FishTypeInAQ> get(long id) throws ServiceException;

	public void delete(FishTypeInAQ fishTypeInAQ) throws ServiceException;

}
