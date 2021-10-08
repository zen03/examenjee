package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Note;




public class NoteDaoImpl implements INote{

private EntityManager em;
	
	public NoteDaoImpl() {
		EntityManagerFactory emf = Persistence
						.createEntityManagerFactory("examenjee");
		
		em = emf.createEntityManager();
	}
	@Override
	public int add(Note note) {
		int ok = 0;
		try {
			em.getTransaction().begin();
			em.persist(note);
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		
		return ok;
	}

	@Override
	public int delete(int idn) {
		int ok = 0;
		try {
			em.remove(em.find(Note.class, idn));
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		return ok;
	}

	@Override
	public int update(Note note) {
		int ok = 0;
		try {
			em.merge(note);
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		return ok;
	}

	@Override
	public List<Note> liste() {
		
		return em.createNamedQuery("Note.findAll").getResultList();
	}

	@Override
	public Note getServiceById(int idn) {
		
		return em.find(Note.class,idn);
	}

	

}
