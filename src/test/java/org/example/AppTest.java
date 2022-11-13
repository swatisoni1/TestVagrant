package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Player;
import org.example.model.Team;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AppTest {
    @Test
    public void teamShouldHave4ForeignPlayers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Team team = objectMapper.readValue(new File("src/test/resources/rcb.json"), Team.class);
        List<Player> players = team.getPlayers();
        int countForeignPlayers = 0;
        for (int i = 0; i < players.size(); i++) {
            if (!("india".equalsIgnoreCase(players.get(i).getCountry()))) {
                countForeignPlayers++;
            }
        }
        Assert.assertTrue("Only 4 Foreign Players Allowed", 4 == countForeignPlayers);
    }

    @Test
    public void teamShouldHaveAtLeast1WicketKeeper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Team team = objectMapper.readValue(new File("src/test/resources/rcb.json"), Team.class);
        List<Player> players = team.getPlayers();
        int countWicketKeeper = 0;
        for (int i = 0; i < players.size(); i++) {
            if (("Wicket-keeper".equalsIgnoreCase(players.get(i).getRole()))) {
                countWicketKeeper++;
            }

        }
        Assert.assertTrue("At Least 1 Wicket Keeper Should Be In Team", 1 <= countWicketKeeper);
    }
}
