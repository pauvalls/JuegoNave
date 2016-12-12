/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Pavallsuser;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author pauva
 */
public class Serviceuser {

    protected EntityManager em;

    public Serviceuser(EntityManager em) {
        this.em = em;
    }

    public void removeUsuario(int id) {
        Pavallsuser a = findUser(id);
        if (a != null) {
            em.remove(a);
        }
    }

    public void adduser(String nom, String pass) {
        Pavallsuser a = new Pavallsuser();
        EntityTransaction tx = em.getTransaction();

        a.setNameuser(nom);
        a.setPassuser(pass);
        try {
            tx.begin();
            em.persist(a);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Pavallsuser findUser(int id) {
        return em.find(Pavallsuser.class, id);
    }

    public int findUserbyname(String name) {
        //  Query query = em.createQuery("SELECT p FROM Pavallsuser p where nameuser = '" +name+"'");
        int ID = -1;

        List<Pavallsuser> pv = findAllusuarios();

        for (int i = 0; i < pv.size(); i++) {
            if (pv.get(i).getNameuser().equals(name)) {
                ID = pv.get(i).getIduser();
            }
        }
        return ID;
    }

    @SuppressWarnings("unchecked")

    public List<Pavallsuser> findAllusuarios() {
        Query query = em.createQuery("SELECT p FROM Pavallsuser p");
        return (List<Pavallsuser>) query.getResultList();
    }

    public List<Pavallsuser> getAllusuarios() {
        TypedQuery<Pavallsuser> q = em.createNamedQuery("Pavallsuser.findAll", Pavallsuser.class);
        List<Pavallsuser> rl = q.getResultList();
       
        return rl;
    }

}
