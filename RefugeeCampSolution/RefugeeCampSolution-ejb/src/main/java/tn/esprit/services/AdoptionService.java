package tn.esprit.services;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.persistence.Adoption;
import tn.esprit.persistence.AdoptionPK;
import tn.esprit.persistence.User;
import tn.esprit.persistence.Refug;


@Stateless
public class AdoptionService implements AdoptionServicesLocal {

	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public void saveOrupdate(Adoption a) {
		
		entityManager.merge(a);
		
	}

	@Override
	public void deleteRefug(Adoption Adoption) {
		
		entityManager.remove(entityManager.merge(Adoption));
		
	}

	@Override
	public void removeAdoption(Adoption adopt) {
		entityManager.remove(entityManager.merge(adopt));	
	}

	@Override
	public List<Adoption> GetAllAdoptions() {
		
		
		List<Adoption> found =null; 
		String jpql= " select u from Adoption u";
		TypedQuery<Adoption> query = entityManager.createQuery(jpql, Adoption.class);
		try {
			found = query.getResultList();
		} catch (Exception ex) {
			Logger.getLogger(AdoptionService.class.getName());}
		return found;
		
	}
	@Override
	public void CreateAdoptions( String description, String etat, Date startDate,String iduser,int idrefug){
		Adoption adopt = new Adoption(description, etat, startDate, iduser, idrefug);

		entityManager.merge(adopt);
	}
	public void CreateAdoption ( String description, String etat, Date startDate,User user,Refug refug){}
	
	
	
	
	
	@Override
	public List<Integer> GetAllRefugeeID() {
		Query query = entityManager.createQuery("select S.refugID  from Refug S ");
		List<Integer> refugees = query.getResultList();
       
		return refugees;
	}
	
	
	

}
	
	