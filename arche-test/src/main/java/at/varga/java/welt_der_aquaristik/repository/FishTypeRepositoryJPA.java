package at.varga.java.welt_der_aquaristik.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.service.spi.ServiceException;

import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.FishType;

public class FishTypeRepositoryJPA implements IFishTypeRepository {

	private static final String PERSISTENCE_UNIT_NAME = "aqdb1";

	@Override
	public void add(FishType fishType) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		em.persist(fishType);

		transaction.commit();

		em.close();

		emf.close();

		System.out.println("Inserted FishType: " + fishType.getId());

	}

	@Override
	public FishType update(FishType fishType) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		FishType mergedFishType = em.merge(fishType);

		transaction.commit();

		em.close();

		emf.close();

		System.out.println("Inserted FishType: " + fishType.getId());

		return mergedFishType;
	}

	@Override
	public List<FishType> getAll() throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		System.out.println("Read all FishTypes");
		transaction.begin();

		@SuppressWarnings("unchecked")
		List<FishType> fishTypeList = (List<FishType>) em.createQuery("FROM FishType", FishType.class).getResultList();

		transaction.commit();
		em.close();
		emf.close();
		return fishTypeList;
	}

	@Override
	public Optional<FishType> get(long id) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		System.out.println("Read an FishType");
		transaction.begin();

		FishType fishType = em.find(FishType.class, id);

		transaction.commit();
		em.close();
		emf.close();
		return Optional.ofNullable(fishType);
	}

	@Override
	public void delete(FishType fishType) throws ServiceException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		System.out.println("Delete FishType: " + fishType.getId());
		transaction.begin();

		if (!em.contains(fishType))
			fishType = em.merge(fishType);

		em.remove(fishType);

		transaction.commit();
		em.close();
		emf.close();

	}

}
