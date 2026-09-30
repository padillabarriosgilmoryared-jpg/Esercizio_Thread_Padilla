package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int percorsoTotale = 100;

        ArrayList<Cavallo> ListaCavallo = new ArrayList<>();

        ListaCavallo.add(new Cavallo("Popescu", percorsoTotale));
        ListaCavallo.add(new Cavallo("Tchakal", percorsoTotale));
        ListaCavallo.add(new Cavallo("Calota", percorsoTotale));
        ListaCavallo.add(new Cavallo("Orlandi", percorsoTotale));
        ListaCavallo.add(new Cavallo("Tagliaferri", percorsoTotale));
        ListaCavallo.add(new Cavallo("Ahamed", percorsoTotale));

        for (Cavallo c : ListaCavallo) {
            c.start();
        }

        for (Cavallo c : ListaCavallo) {
            try {
                c.join();
            } catch (InterruptedException e) {
                System.out.println("Il thread è stato interrotto");
            }
        }

        System.out.println("\nCLASSIFICA FINALE:");

        for (int i = 0; i < Cavallo.classifica.size(); i++) {
            System.out.println((i + 1) + "° posto: "+ Cavallo.classifica.get(i));
        }
    }
}
