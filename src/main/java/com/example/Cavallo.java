package com.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cavallo extends Thread {
    private String nome;
    private int percorsoTotale;
    private int distanzaPercorsa;
    private static boolean garaFinita = false;

    public static ArrayList<String> classifica = new ArrayList<>();

    public Cavallo(String nome, int percorsoTotale) {
        this.nome = nome;
        this.percorsoTotale = percorsoTotale;
        this.distanzaPercorsa = 0;
    }

    @Override
    public void run() {
        while (distanzaPercorsa < percorsoTotale) {
            Random random = new Random();

            try {
                int tempoSleep = random.nextInt(400) + 400;
                Thread.sleep(tempoSleep);
            } catch (InterruptedException e) {
                System.out.println("Il thread è stato interrotto");
            }

            int avanzamento;
            avanzamento = random.nextInt(10) + 1;

            distanzaPercorsa = distanzaPercorsa + avanzamento;

            if (distanzaPercorsa >= percorsoTotale) {
                if (!garaFinita) {
                    garaFinita = true;

                    System.out.println("\nGara finita, il vincitore è " + nome + "\n");
                }
            }

            System.out.println(nome + " ha percorso "+ distanzaPercorsa + " metri");
        }

        classifica.add(nome);

        System.out.println(nome + " ha terminato la gara!");
    }
}
