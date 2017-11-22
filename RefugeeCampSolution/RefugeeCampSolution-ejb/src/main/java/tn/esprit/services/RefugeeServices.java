package tn.esprit.services;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tn.esprit.persistence.Refug;;

@Stateless
public class RefugeeServices implements RefugeeServicesLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public RefugeeServices(){   
		}
	@Override
	public void saveOrupdate(Refug refugee) {
		entityManager.merge(refugee);		
	}

	@Override
	public void deleteRefug(Refug refugee) {
		entityManager.remove(entityManager.merge(refugee));		
	}

	@Override
	public Refug findRefugById(Integer idRefugee) {
			return entityManager.find(Refug.class, idRefugee);	}

	@Override
	public List<Refug> GetAllRefug() {
		Query query = entityManager.createQuery("select c from Refug c");
		List<Refug> refugee = query.getResultList();

		return refugee;
	}
	
	
	
	
	

}
