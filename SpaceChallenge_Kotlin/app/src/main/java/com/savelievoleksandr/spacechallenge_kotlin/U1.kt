package com.savelievoleksandr.spacechallenge_kotlin

class U1 : Rocket(100, 10000, 18000, 0.05, 0.01) {

    override fun launch(): Boolean {
        val random = Math.random()
        return chanceOfLaunchExplosion * (totalWeight - spaceshipWeight) / (maxWeight - spaceshipWeight) <= random
    }

    override fun land(): Boolean {
        val random = Math.random()
        return chanceOfLandingCrash * (totalWeight - spaceshipWeight) / (maxWeight - spaceshipWeight) <= random
    }
}