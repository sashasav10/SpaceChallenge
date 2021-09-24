package com.savelievoleksandr.spacechallenge_kotlin

interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(item: Item): Boolean
    fun carry(item: Item): Int
}