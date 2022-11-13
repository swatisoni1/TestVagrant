package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Team {

    @JsonProperty("name")
    private String name;
    @JsonProperty("location")
    private String location;
    @JsonProperty("player")
    private List<Player> players;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
