package com.example.spacechallenge_java;

public class U2 extends Rocket{
    public U2() {
        super(120, 18000, 29000, 0.04, 0.08);
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
