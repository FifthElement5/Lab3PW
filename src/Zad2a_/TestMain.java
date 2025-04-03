package Zad2a_;

import java.util.Arrays;
import java.util.Random;


public class TestMain {
    public static void main(String[] args) {

        int N = 200000000;

        int[] tablica = new int[N];

        Random random = new Random();
        for(int i = 0; i < N; i++) {

            int liczba = random.nextInt();
            tablica[i] = liczba;

        }

   int liczbaWatkow = 500;
        int rozmiarSegmentu = N/liczbaWatkow;

        // Tworzymy obiekt MinMax (wątek) w tablicy

        MinMax[] watki = new MinMax[liczbaWatkow];

        for(int i = 0; i < liczbaWatkow; i++ ) {
            int start = i * rozmiarSegmentu;
            int end;
            if (i == liczbaWatkow - 1) {
                end = N; // ostni watek obejmuje tablice
            } else {
                end = start + rozmiarSegmentu; //standardowy podzial
            }
            watki[i] = new MinMax(tablica ,  start, end);
            watki[i].setName("Watek-" + i);
        }


        long startTime = System.nanoTime();

        for (int i = 0; i < liczbaWatkow; i++) {
            watki[i].start();
        }

// czeka na  zakończenie wszystkich wątków
        for (int i = 0; i < liczbaWatkow; i++) {
            try {
                watki[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


//        for (int i = 0; i < liczbaWatkow; i++) {
//            watki[i].rysuj();
//        }



        //  Tworzymy tablice na min/max po zakończeniu wątków
        int[] MIN = new int[liczbaWatkow];
        int[] MAX = new int[liczbaWatkow];

        for (int i = 0; i < liczbaWatkow; i++) {
            MIN[i] = watki[i].getMin();
            MAX[i] = watki[i].getMax();
        }

//        for (int i = 0; i < liczbaWatkow; i++) {
//           System.out.print("min tabela:" + MIN[i] );
//           System.out.println("max tabela: " + MAX[i]);
//        }


        //  Znalezienie globalnego min i max
        int globalMin = Arrays.stream(MIN).min().getAsInt();
        int globalMax = Arrays.stream(MAX).max().getAsInt();

        long endTime = System.nanoTime();
        long durationNs = endTime - startTime;
        double durationMs = durationNs / 1_000_000.0; // Konwersja na

        System.out.println("Minimalna wartość: " + globalMin);
        System.out.println("Maksymalna wartość: " + globalMax);


        System.out.println("Czas wyszukiwania min/max: " + durationNs + " ns");
        System.out.println("Czas wyszukiwania min/max: " + durationMs + " ms");



    }


}