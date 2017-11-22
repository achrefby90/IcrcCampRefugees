package tn.esprit.services;

import javax.ejb.Remote;

import tn.esprit.persistence.User;

@Remote
public interface IRemoteUser {

	public User checkLogin(String token);

}
