package com.example.spacechallenge_java;

public class U1 extends Rocket {

    public U1() {
        super(100, 10000, 18000, 0.05, 0.01);
        setTotalWeight(getSpaceshipWeight());
    }

    @Override
    public boolean launch() {
        double random = Math.random();
        return getChanceOfLaunchExplosion() * (getTotalWeight() - getSpaceshipWeight()) / (getMaxWeight() - getSpaceshipWeight()) <= random;
    }

    @Override
    public boolean land() {
        double random = Math.random();
        return getChanceOfLandingCrash() * (getTotalWeight() - getSpaceshipWeight()) / (getMaxWeight() - getSpaceshipWeight()) <= random;
    }
}
