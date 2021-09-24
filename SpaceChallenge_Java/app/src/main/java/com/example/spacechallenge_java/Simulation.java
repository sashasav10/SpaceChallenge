package com.example.spacechallenge_java;

import android.content.res.AssetManager;
import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    private Context context;
    private String[] linesInFile;

    public Simulation(Context context) {
        this.context = context;
    }
    public ArrayList<Item> loadItems(String fileName) throws IOException {
        AssetManager asset = context.getAssets();
        ArrayList<Item> items = new ArrayList<>();
        Scanner scanedFiles = new Scanner(asset.open(fileName));
        while (scanedFiles.hasNextLine()) {
            linesInFile = scanedFiles.nextLine().split("=");
            Item item = new Item(linesInFile[0], Integer.parseInt(linesInFile[1]));
            items.add(item);
        }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemList) {
        ArrayList<Rocket> rocketU1List = new ArrayList();
        U1 rocketU1 = new U1();
        for (Item ite : itemList) {
            if (rocketU1.canCarry(ite)) rocketU1.carry(ite);
            else {
                rocketU1List.add(rocketU1);
                rocketU1 = new U1();
                rocketU1.carry(ite);
            }
        }
        return rocketU1List;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemList) {
        ArrayList<Rocket> rocketU2List = new ArrayList();
        U2 rocketU2 = new U2();
        for (Item ite : itemList) {
            if (rocketU2.canCarry(ite)) rocketU2.carry(ite);
            else {
                rocketU2List.add(rocketU2);
                rocketU2 = new U2();
                rocketU2.carry(ite);
            }
        }
        return rocketU2List;
    }

    public int runSimulation(ArrayList<Rocket> rocketList) {
        int budget = 0;
        for (Rocket ro : rocketList) {
            budget += ro.getCost();
            while (!ro.land() || !ro.launch()) {
                budget += ro.getCost();
            }
        }
        return budget;
    }

}
