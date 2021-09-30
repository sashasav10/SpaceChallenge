package com.savelievoleksandr.spacechallenge_kotlin

open class Rocket(
    val cost: Int,
    val spaceshipWeight: Int,
    val maxWeight: Int,
    val chanceOfLaunchExplosion: Double,
    val chanceOfLandingCrash: Double
) :
    SpaceShip {
    var totalWeight = spaceshipWeight

    override fun land(): Boolean = true

    override fun launch(): Boolean = true

    override fun canCarry(item: Item): Boolean {
        return totalWeight + item.weight <= maxWeight
    }

    override fun carry(item: Item): Int {
        totalWeight += item.weight
        return totalWeight
    }

}