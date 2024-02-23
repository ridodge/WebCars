/**
 * Riley Dodge - tjrace
 * CIS175 - Fall 2023
 * Feb 21, 2024
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.TripDetails;

/**
 * 
 */
public class TripDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Cars");

	public void insertNewTripDetails(TripDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<TripDetails> getTrips() {
		EntityManager em = emfactory.createEntityManager();
		List<TripDetails> allDetails = em.createQuery("SELECT d FROM TripDetails d").getResultList();
		return allDetails;
	}

	public void deleteList(TripDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TripDetails> typedQuery = em
				.createQuery("select detail from TripDetails detail where detail.id = :selectedId", TripDetails.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		TripDetails result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public TripDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TripDetails found = em.find(TripDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateList(TripDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}