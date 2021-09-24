package com.savelievoleksandr.spacechallenge_kotlin

class U2 : Rocket(120, 18000, 29000, 0.04, 0.08) {

    override fun launch(): Boolean {
        val random = Math.random()
        return chanceOfLaunchExplosion * (totalWeight - spaceshipWeight) / (maxWeight - spaceshipWeight) <= random
    }

    override fun land(): Boolean {
        val random = Math.random()
        return chanceOfLandingCrash * (totalWeight - spaceshipWeight) / (maxWeight - spaceshipWeight) <= random
    }
}