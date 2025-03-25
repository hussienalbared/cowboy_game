package com.example;

import java.io.*;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;



// Game logic
public class Game {
    private final List<Cowboy> people = new ArrayList<>();
    private final Random random = new Random();
    private final JSONArray logArray = new JSONArray();
    private static final String JSON_FILE = "protocol.json";
    JSONObject jsonObject = new JSONObject();

    public Game(int numPeople) {
        // Create people
        for (int i = 0; i < numPeople; i++) {
            people.add(new Cowboy("Person " + (i + 1)));
        }

        // Link them in a circular manner
        for (int i = 0; i < numPeople; i++) {
            Cowboy current = people.get(i);
            current.setLeft(people.get((i - 1 + numPeople) % numPeople));
            current.setRight(people.get((i + 1) % numPeople));
        }
    }

    public void start() {
        Cowboy current = people.get(random.nextInt(people.size())); // Start randomly

        while (people.size() > 1) {
            JSONObject logEntry = new JSONObject();
            logEntry.put("shooter", current.getName());
            logEntry.put("shooter_health", current.getHealthPoints());

            // Choose target
            Cowboy target = (current.getHealthPoints() % 2 == 0) ? current.getRight() : current.getLeft();
            int damage = random.nextInt(5) + 1; // Random damage (1-5)
            target.setHealthPoints(target.getHealthPoints() - damage);

            logEntry.put("target", target.getName());
            logEntry.put("damage", damage);
            logEntry.put("target_health_after", Math.max(target.getHealthPoints(), 0));

            System.out.println(current.getName() + " shot " + target.getName() + " for " + damage +
                    " damage! " + target.getName() + " has " + Math.max(target.getHealthPoints(), 0) + " HP left.");

            logArray.put(logEntry);

            // If target dies, remove them
            if (target.getHealthPoints() <= 0) {
                System.out.println(target.getName() + " has died!");
                removePerson(target);
            } else {
                current = target; // Target takes the turn
            }
        }

        // Log winner
        JSONObject winnerEntry = new JSONObject();
        String winnerName = people.get(0).getName();
        System.out.println("Winner is " + winnerName);
        winnerEntry.put("name", winnerName);
        winnerEntry.put("health_points", people.get(0).getHealthPoints());
        logArray.put(winnerEntry);

        jsonObject.put("game_simulation", logArray);
        jsonObject.put("winner", winnerEntry);

        // Write JSON log
         FileHandler.writeJsonFile(jsonObject, JSON_FILE);



        // Compute and write MD5 checksum
        String checksum = FileHandler.calculateMD5Checksum(JSON_FILE);
        System.out.println("\nMD5 Checksum: " + checksum);


    }

    private void removePerson(Cowboy target) {
        target.getLeft().setRight(target.getRight());
        target.getRight().setLeft(target.getLeft());
        people.remove(target);
    }
}

