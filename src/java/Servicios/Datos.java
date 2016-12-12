/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.Date;

/**
 *
 * @author pauva
 */
public class Datos {

    String User;
    double score;
    String date;
    int contador;

    public Datos(String User, double score) {
        this.User = User;
        this.score = score;
    }

    public Datos(String User, int partidas) {
        this.User = User;
        this.contador = partidas;
    }

    public Datos(String User, String date) {
        this.User = User;
        this.date = date;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getUser() {
        return User;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
