/**
 * 
 */
package at.varga.java.welt_der_aquaristik.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;

import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;

/**
 * @author eszte
 *
 */
public interface IAQRepository {
	
	public void add(AQ aq) throws ServiceException;
	
	public AQ update(AQ aq) throws ServiceException;

	public List<AQ> getAll() throws ServiceException;

	public Optional<AQ> get(long id) throws ServiceException;

	public void delete(AQ aq) throws ServiceException;

}
