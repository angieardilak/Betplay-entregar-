package com.soccer;

import java.util.HashMap;
import java.util.Map;

import com.soccer.model.entity.Team;

public class Controller {
    private Map<String, Team> equipos;

    public Controller() {
        this.equipos = new HashMap<>();
    }

    public void addTeam(String codigoEquipo, Team equipo) {
        equipos.put(codigoEquipo, equipo);
    }

    public Team getTeam(String codigoEquipo) {
        return equipos.get(codigoEquipo);
    }

    public Team removeTeam(String codigoEquipo) {
        return equipos.remove(codigoEquipo);
    }

    public Map<String, Team> getAllTeams() {
        return equipos;
    }
}
