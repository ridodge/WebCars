/**
 * Riley Dodge - tjrace
 * CIS175 - Fall 2023
 * Feb 21, 2024
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Driver;

/**
 * 
 */
public class DriverHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Cars");

	public void insertDriver(Driver d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}

	public List<Driver> showAllDrivers() {
		EntityManager em = emfactory.createEntityManager();
		List<Driver> allDrivers = em.createQuery("SELECT d FROM Driver d").getResultList();
		return allDrivers;
	}


	public Driver findDriver(String nameToLookUp) {
		EntityManager em =
		emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Driver> typedQuery = em.createQuery("select dr from Driver dr where dr.driverName = :selectedName", Driver.class);

		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);

		Driver foundDriver;
		try {
		foundDriver = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
		foundDriver = new Driver(nameToLookUp);
		}
		em.close();
		return foundDriver;
		}
		

}
