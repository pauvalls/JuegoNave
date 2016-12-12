/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Pavallsscore;
import Entidades.Pavallsuser;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author pauva
 */
public class ServiceScore {

    EntityManager em;

    public ServiceScore(EntityManager em) {
        this.em = em;
    }

    public void removeUsuario(int id) {
        Pavallsscore a = findUser(id);
        if (a != null) {
            em.remove(a);
        }
    }

    public void adduser(Pavallsuser id, java.sql.Date dateinicio) {
        Pavallsscore a = new Pavallsscore();
        EntityTransaction tx = em.getTransaction();

        a.setIdjugador(id);
        a.setInicio(dateinicio);

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

    public void adduser(Pavallsuser id, java.sql.Date dateinicio, java.sql.Date datefin, double puntuacion) {
        Pavallsscore a = new Pavallsscore();
        EntityTransaction tx = em.getTransaction();

        a.setIdjugador(id);
        a.setInicio(dateinicio);
        a.setFinal1(datefin);
        a.setPuntuacion(puntuacion);

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

    public Pavallsscore findUser(int id) {
        return em.find(Pavallsscore.class, id);
    }

    public ArrayList<Datos> getranking() {

        ArrayList<Datos> ranking = new ArrayList<Datos>();
        String sql = "SELECT nameuser as users, puntuacion as score   FROM pavallsuser , pavallsscore where iduser = idjugador order by puntuacion desc limit 10";
        Query consulta = em.createNativeQuery(sql);
        List<Object[]> lista = consulta.getResultList();

        for (Object[] objects : lista) {
            String nombre = String.valueOf(objects[0]);
            String puntuacion = String.valueOf(objects[1]);
            double puntu = Double.parseDouble(puntuacion);
            Datos r = new Datos(nombre, puntu);
            ranking.add(r);
        }

        return ranking;

    }

    @SuppressWarnings("unchecked")

    public List<Pavallsscore> findAllusuarios() {
        Query query = em.createQuery("SELECT p FROM Pavallsscore p");
        return (List<Pavallsscore>) query.getResultList();
    }

    public List<Pavallsscore> getAllusuarios() {
        TypedQuery<Pavallsscore> q = em.createNamedQuery("Pavallsscore.findAll", Pavallsscore.class);
        List<Pavallsscore> rl = q.getResultList();
        return rl;
    }

    public ArrayList<Datos> getLastLogin() {

        ArrayList<Datos> ranking = new ArrayList<Datos>();
        String sql = "select nameuser, max (final) from pavallsscore,pavallsuser where idjugador=iduser group by nameuser ";
        Query consulta = em.createNativeQuery(sql);
        List<Object[]> lista = consulta.getResultList();
        for (Object[] objects : lista) {
            String nombre = String.valueOf(objects[0]);
            String date = String.valueOf(objects[1]);

            Datos r = new Datos(nombre, date);
            ranking.add(r);
        }

        return ranking;

    }

    public ArrayList<Datos> getMostvitiated() {

        ArrayList<Datos> ranking = new ArrayList<Datos>();
        String sql = "select nameuser, Count (puntuacion)  from pavallsscore, pavallsuser \n"
                + "where iduser=idjugador \n"
                + "group by nameuser";
        Query consulta = em.createNativeQuery(sql);
        List<Object[]> lista = consulta.getResultList();
        for (Object[] objects : lista) {
            String nombre = String.valueOf(objects[0]);
            int puntu = Integer.parseInt(String.valueOf(objects[1]));
            Datos r = new Datos(nombre, puntu);

            ranking.add(r);
        }

        return ranking;

    }

}
