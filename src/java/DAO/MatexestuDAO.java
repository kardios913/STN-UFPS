/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import Modelo.Matexestu;
import Modelo.MatexestuPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author KRLOS
 */
public class MatexestuDAO implements Serializable {

    public MatexestuDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public MatexestuDAO() {
       this.emf=Persistence.createEntityManagerFactory("STN1151000PU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Matexestu matexestu) throws PreexistingEntityException, Exception {
        if (matexestu.getMatexestuPK() == null) {
            matexestu.setMatexestuPK(new MatexestuPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(matexestu);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMatexestu(matexestu.getMatexestuPK()) != null) {
                throw new PreexistingEntityException("Matexestu " + matexestu + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Matexestu matexestu) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            matexestu = em.merge(matexestu);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                MatexestuPK id = matexestu.getMatexestuPK();
                if (findMatexestu(id) == null) {
                    throw new NonexistentEntityException("The matexestu with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(MatexestuPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Matexestu matexestu;
            try {
                matexestu = em.getReference(Matexestu.class, id);
                matexestu.getMatexestuPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The matexestu with id " + id + " no longer exists.", enfe);
            }
            em.remove(matexestu);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

   
    public List<Matexestu> findMatexestuEntities() {
        return findMatexestuEntities(true, -1, -1);
    }

    public List<Matexestu> findMatexestuEntities(int maxResults, int firstResult) {
        return findMatexestuEntities(false, maxResults, firstResult);
    }

    private List<Matexestu> findMatexestuEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Matexestu.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Matexestu findMatexestu(MatexestuPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Matexestu.class, id);
        } finally {
            em.close();
        }
    }

    public int getMatexestuCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Matexestu> rt = cq.from(Matexestu.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
