package com.savelievoleksandr.spacechallenge_kotlin

import android.content.Context
import java.util.*
import kotlin.collections.ArrayList

class Simulation(private val context: Context) {
    fun loadItems(fileName: String): ArrayList<Item> {
        val asset = context.assets
        val items = ArrayList<Item>()
        val scanedFiles = Scanner(asset.open(fileName))
        while (scanedFiles.hasNextLine()) {
            val linesInFile = scanedFiles.nextLine().split("=".toRegex()).toTypedArray()
            val item = Item(linesInFile[0], linesInFile[1].toInt())
            items.add(item)
        }
        return items
    }

    fun loadU1(itemList: ArrayList<Item>): ArrayList<Rocket> {
        val rocketU1List: ArrayList<Rocket> = ArrayList()
        var rocketU1 = U1()
        for (item in itemList) {
            if (rocketU1.canCarry(item)) rocketU1.carry(item) else {
                rocketU1List.add(rocketU1)
                rocketU1 = U1()
                rocketU1.carry(item)
            }
        }
        return rocketU1List
    }

    fun loadU2(itemList: ArrayList<Item>): ArrayList<Rocket> {
        val rocketU2List: ArrayList<Rocket> = ArrayList()
        var rocketU2 = U2()
        for (item in itemList) {
            if (rocketU2.canCarry(item)) rocketU2.carry(item) else {
                rocketU2List.add(rocketU2)
                rocketU2 = U2()
                rocketU2.carry(item)
            }
        }
        return rocketU2List
    }

    fun runSimulation(rocketList: ArrayList<Rocket>): Int {
        var budget = 0
        for (rocket in rocketList) {
            budget += rocket.cost
            while (!rocket.land() || !rocket.launch()) {
                budget += rocket.cost
            }
        }
        return budget
    }
}
