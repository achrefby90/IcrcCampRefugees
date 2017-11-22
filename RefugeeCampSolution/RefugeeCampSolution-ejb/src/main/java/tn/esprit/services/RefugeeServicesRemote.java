package tn.esprit.services;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.persistence.Refug;

@Remote
public interface RefugeeServicesRemote {

	void saveOrupdate(Refug refugee);

	void deleteRefug(Refug refugee);

	Refug findRefugById(Integer idRefugee);

	List<Refug> GetAllRefug();

}
