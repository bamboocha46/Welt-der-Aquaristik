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

import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;

/**
 * @author eszte
 *
 */
public class AQRepositoryJPA implements IAQRepository {

	private static final String PERSISTENCE_UNIT_NAME = "aqdb1";

	@Override
	public void add(AQ aq) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		em.persist(aq);

		transaction.commit();

		em.close();

		emf.close();

		System.out.println("Inserted AQ: " + aq.getAqId());

	}

	@Override
	public AQ update(AQ aq) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		AQ mergedAQ = em.merge(aq);

		transaction.commit();

		em.close();

		emf.close();

		System.out.println("Inserted AQ: " + aq.getAqId());

		return mergedAQ;
	}

	@Override
	public List<AQ> getAll() throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		System.out.println("Read all AQs");
		transaction.begin();

		@SuppressWarnings("unchecked")
		//FROM User u WHERE  u.email = :email
//		List<AQ> aqList = (List<AQ>) em.createQuery("FROM aqdb1.aqs")
//		.getResultList();
		List<AQ> aqList = (List<AQ>) em.createQuery("FROM AQ", AQ.class)
		.getResultList();
//		List<AQ> aqList = (List<AQ>) em.createQuery("SELECT * FROM aqdb1.aqs")
//				.getResultList();

		transaction.commit();
		em.close();
		emf.close();
		return aqList;
	}

	@Override
	public Optional<AQ> get(long id) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		System.out.println("Read an AQ");
		transaction.begin();

		AQ aq = em.find(AQ.class, id);

		transaction.commit();
		em.close();
		emf.close();
		return Optional.ofNullable(aq);
	}

	@Override
	public void delete(AQ aq) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		System.out.println("Delete AQ: " + aq.getAqId());
		transaction.begin();

		if (!em.contains(aq))
			aq = em.merge(aq);

		em.remove(aq);

		transaction.commit();
		em.close();
		emf.close();

	}

}
