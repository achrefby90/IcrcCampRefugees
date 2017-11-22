package tn.esprit.services;

import java.util.List;
import javax.ejb.Local;
import tn.esprit.persistence.Refug;

@Local
public interface RefugeeServicesLocal {

	void saveOrupdate(Refug refugee);

	void deleteRefug(Refug refugee);

	Refug findRefugById(Integer idRefugee);

	List<Refug> GetAllRefug();

}
