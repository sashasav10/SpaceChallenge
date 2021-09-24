package com.example.spacechallenge_java;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView textvBudgetU1Phase1;
    TextView textvBudgetU1Phase2;
    TextView textvBudgetU2Phase1;
    TextView textvBudgetU2Phase2;
    Simulation simulation1 = new Simulation(this);
    Simulation simulation2 = new Simulation(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textvBudgetU1Phase1 = findViewById(R.id.textvBudgetU1Phase1);
        textvBudgetU1Phase2 = findViewById(R.id.textvBudgetU1Phase2);
        textvBudgetU2Phase1 = findViewById(R.id.textvBudgetU2Pase1);
        textvBudgetU2Phase2 = findViewById(R.id.textvBudgetU2Phase2);
    }

    @SuppressLint("SetTextI18n")
    public void startSimulation(View view) throws IOException {
        //Budget for two phases for U1 rocket
        int totalBudgetU1Phase1 = simulation1.runSimulation(simulation1.loadU1(simulation1.loadItems("Phase-1.txt")));
        int totalBudgetU1Phase2 = simulation1.runSimulation(simulation1.loadU1(simulation1.loadItems("Phase-2.txt")));
        textvBudgetU1Phase1.setText("Phase 1: " + totalBudgetU1Phase1 + " M$");
        textvBudgetU1Phase2.setText("Phase 2: " + totalBudgetU1Phase2 + " M$");

        //Budget for two phases for U2 rocket
        int totalBudgetU2Phase1 = simulation2.runSimulation(simulation2.loadU2(simulation2.loadItems("Phase-1.txt")));
        int totalBudgetU2Phase2 = simulation2.runSimulation(simulation2.loadU2(simulation2.loadItems("Phase-2.txt")));
        textvBudgetU2Phase1.setText("Phase 1: " + totalBudgetU2Phase1 + " M$");
        textvBudgetU2Phase2.setText("Phase 2: " + totalBudgetU2Phase2 + " M$");
    }
}