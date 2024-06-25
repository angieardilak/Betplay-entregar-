package com.soccer.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String nombre;
    private String ciudad;
    private List<Player> lstJugadores;
    private List<Coach> lstEntrenadores;
    private List<Doctor> lstMasajistas;

    public Team(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.lstEntrenadores = new ArrayList<>();
        this.lstJugadores = new ArrayList<>();
        this.lstMasajistas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Player> getLstJugadores() {
        return lstJugadores;
    }

    public void addJugador(Player jugador) {
        this.lstJugadores.add(jugador);
    }

    public boolean removeJugador(Player jugador) {
        return this.lstJugadores.remove(jugador);
    }

    public List<Coach> getLstEntrenadores() {
        return lstEntrenadores;
    }

    public void addEntrenador(Coach entrenador) {
        this.lstEntrenadores.add(entrenador);
    }

    public boolean removeEntrenador(Coach entrenador) {
        return this.lstEntrenadores.remove(entrenador);
    }

    public List<Doctor> getLstMasajistas() {
        return lstMasajistas;
    }

    public void addMasajista(Doctor masajista) {
        this.lstMasajistas.add(masajista);
    }

    public boolean removeMasajista(Doctor masajista) {
        return this.lstMasajistas.remove(masajista);
    }

    @Override
    public String toString() {
        return "Team{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", lstJugadores=" + lstJugadores +
                ", lstEntrenadores=" + lstEntrenadores +
                ", lstMasajistas=" + lstMasajistas +
                '}';
    }
}
