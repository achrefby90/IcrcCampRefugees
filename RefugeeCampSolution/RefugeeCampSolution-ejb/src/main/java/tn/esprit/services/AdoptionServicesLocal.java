package tn.esprit.services;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

import tn.esprit.persistence.Adoption;
import tn.esprit.persistence.User;
import tn.esprit.persistence.Refug;

@Local
public interface AdoptionServicesLocal {

	void saveOrupdate (Adoption a);
	void deleteRefug(Adoption Adoption);
	List<Adoption> GetAllAdoptions();
	void CreateAdoption(String description, String etat, Date startDate,User user,Refug refug);
	void CreateAdoptions(String description, String etat, Date startDate, String iduser, int idrefug);
	void removeAdoption(Adoption adopt);
	List<Integer> GetAllRefugeeID();

}
