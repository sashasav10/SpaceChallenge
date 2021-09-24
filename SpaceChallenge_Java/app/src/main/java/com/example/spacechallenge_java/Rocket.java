package com.example.spacechallenge_java;

public class Rocket implements SpaceShip {
    private final int maxWeight;
    private int spaceshipWeight;
    private int totalWeight = spaceshipWeight;
    private final int cost;
    private final double chanceOfLandingCrash;
    private final double chanceOfLaunchExplosion;

    public Rocket(int cost, int spaceshipWeight, int maxWeight, double chanceOfLaunchExplosion, double chanceOfLandingCrash) {
        this.maxWeight = maxWeight;
        this.spaceshipWeight = spaceshipWeight;
        this.cost = cost;
        this.chanceOfLaunchExplosion = chanceOfLaunchExplosion;
        this.chanceOfLandingCrash = chanceOfLandingCrash;
    }


    public boolean land() {
        return true;
    }

    public boolean launch() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return this.totalWeight + item.weight <= maxWeight;
    }

    @Override
    public int carry(Item item) {
        this.totalWeight += item.weight;
        return this.totalWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getSpaceshipWeight() {
        return spaceshipWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getCost() {
        return cost;
    }

    public double getChanceOfLaunchExplosion() {
        return chanceOfLaunchExplosion;
    }

    public double getChanceOfLandingCrash() {
        return chanceOfLandingCrash;
    }

}