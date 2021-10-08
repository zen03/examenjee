package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.Etudiant;



public class EtudiantDaoImpl implements IEtudiant{

	private EntityManager em;
	
	public EtudiantDaoImpl() {
		EntityManagerFactory emf = Persistence
						.createEntityManagerFactory("examenjee");
		
		em = emf.createEntityManager();
	}
	@Override
	public int add(Etudiant etdudiant) {
		int ok = 0;
		try {
			em.getTransaction().begin();
			em.persist(etdudiant);
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		
		return ok;
	}

	@Override
	public int delete(int mat) {
		int ok = 0;
		try {
			em.getTransaction().begin();
			em.remove(em.find(Etudiant.class, mat));
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		return ok;
	}

	@Override
	public int update(Etudiant etudiant) {
		int ok = 0;
		try {
			em.getTransaction().begin();
			em.merge(etudiant);
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		return ok;
	}

	@Override
	public List<Etudiant> liste() {
		
		return em.createNamedQuery("Etudiant.findAll").getResultList();
	}

	@Override
	public Etudiant getServeurById(int mat) {
		
		return em.find(Etudiant.class,mat);
	}

}
