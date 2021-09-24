package com.savelievoleksandr.spacechallenge_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var textvBudgetU1Phase1: TextView
    private lateinit var textvBudgetU1Phase2: TextView
    private lateinit var textvBudgetU2Phase1: TextView
    private lateinit var textvBudgetU2Phase2: TextView
    private var simulation1 = Simulation(this)
    private var simulation2 = Simulation(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textvBudgetU1Phase1 = findViewById(R.id.textvBudgetU1Phase1)
        textvBudgetU1Phase2 = findViewById(R.id.textvBudgetU1Phase2)
        textvBudgetU2Phase1 = findViewById(R.id.textvBudgetU2Pase1)
        textvBudgetU2Phase2 = findViewById(R.id.textvBudgetU2Phase2)
    }

    @SuppressLint("SetTextI18n")
    @Throws(IOException::class)
    fun startSimulation(view: View?) {
        //Budget for two phases for U1 rocket
        val totalBudgetU1Phase1 =
            simulation1.runSimulation(simulation1.loadU1(simulation1.loadItems("Phase-1.txt")))
        val totalBudgetU1Phase2 =
            simulation1.runSimulation(simulation1.loadU1(simulation1.loadItems("Phase-2.txt")))
        textvBudgetU1Phase1.text = "Phase 1: $totalBudgetU1Phase1 M$"
        textvBudgetU1Phase2.text = "Phase 2: $totalBudgetU1Phase2 M$"

        //Budget for two phases for U2 rocket
        val totalBudgetU2Phase1 =
            simulation2.runSimulation(simulation2.loadU2(simulation2.loadItems("Phase-1.txt")))
        val totalBudgetU2Phase2 =
            simulation2.runSimulation(simulation2.loadU2(simulation2.loadItems("Phase-2.txt")))
        textvBudgetU2Phase1.text = "Phase 1: $totalBudgetU2Phase1 M$"
        textvBudgetU2Phase2.text = "Phase 2: $totalBudgetU2Phase2 M$"
    }
}