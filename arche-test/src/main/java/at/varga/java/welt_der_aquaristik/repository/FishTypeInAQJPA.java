/**
 * 
 */
package at.varga.java.welt_der_aquaristik.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.service.spi.ServiceException;

import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;

/**
 * @author eszte
 *
 */
public class FishTypeInAQJPA implements IFishTypeInAQRepository {

	private static final String PERSISTENCE_UNIT_NAME = "aqdb1";

	@Override
	public void add(FishTypeInAQ fishTypeInAQ) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		em.persist(fishTypeInAQ);

		transaction.commit();

		em.close();

		emf.close();

		System.out.println("Inserted FishTypeInAQ: " + fishTypeInAQ.getId());

	}

	@Override
	public FishTypeInAQ update(FishTypeInAQ fishTypeInAQ) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		FishTypeInAQ mergedFishTypeInAQ = em.merge(fishTypeInAQ);

		transaction.commit();

		em.close();

		emf.close();

		System.out.println("Inserted FishTypeInAQ: " + fishTypeInAQ.getId());

		return mergedFishTypeInAQ;
	}

	@Override
	public List<FishTypeInAQ> getAll() throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		System.out.println("Read all FishTypesInAQ");
		transaction.begin();

		@SuppressWarnings("unchecked")
		List<FishTypeInAQ> fishTypeInAQList = (List<FishTypeInAQ>) em.createQuery("select * from FishTypeInAQ")
				.getResultList();

		transaction.commit();
		em.close();
		emf.close();
		return fishTypeInAQList;
	}

	@Override
	public Optional<FishTypeInAQ> get(long id) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		System.out.println("Read one FishType from Aq");
		transaction.begin();

		FishTypeInAQ fishTypeInAQ = em.find(FishTypeInAQ.class, id);

		transaction.commit();
		em.close();
		emf.close();
		return Optional.ofNullable(fishTypeInAQ);
	}

	@Override
	public void delete(FishTypeInAQ fishTypeInAQ) throws ServiceException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		System.out.println("Delete FishTypeInAQ: " + fishTypeInAQ.getId());
		transaction.begin();

		if (!em.contains(fishTypeInAQ))
			fishTypeInAQ = em.merge(fishTypeInAQ);

		em.remove(fishTypeInAQ);

		transaction.commit();
		em.close();
		emf.close();

	}

}
