package com.example;

// Class for a person in the game
public class Cowboy {
    private final String name;
    private int healthPoints;
    private Cowboy left;
    private Cowboy right;

    public Cowboy(String name) {
        this.name = name;
        this.healthPoints = 10;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Cowboy getLeft() {
        return left;
    }

    public void setLeft(Cowboy left) {
        this.left = left;
    }

    public Cowboy getRight() {
        return right;
    }

    public void setRight(Cowboy right) {
        this.right = right;
    }
}
