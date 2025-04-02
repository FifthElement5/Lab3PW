package Zad1_;

import java.util.Arrays;
import java.util.Random;


public class TestMain {
    public static void main(String[] args) {

        int N = 20;

        int[] tablica = new int[N];

        Random random = new Random();
        for(int i = 0; i < N; i++) {

            int liczba = random.nextInt(20);
            tablica[i] = liczba;

        }
        // Podział na dwie połowy:
        int polowa = N / 2;
        int czwarta = polowa / 2;
//        int[] tablica1 = Arrays.copyOfRange(tablica, 0, polowa);
//        int[] tablica2 = Arrays.copyOfRange(tablica, polowa, N);
//
//        int[] tablica1a = Arrays.copyOfRange(tablica1, 0, czwarta);
//        int[] tablica1b = Arrays.copyOfRange(tablica1, czwarta, polowa);
//
//
//        int[] tablica2a = Arrays.copyOfRange(tablica2,0, czwarta);
//        int[] tablica2b = Arrays.copyOfRange(tablica2, czwarta, polowa);



        // Tworzymy obiekt MinMax (wątek)
//        MinMax watek1 = new MinMax(polowa, tablica1);
//        MinMax watek2 = new MinMax(N - polowa, tablica2);

        MinMax watek1 = new MinMax(tablica, 0,N);
       // MinMax watek2 = new MinMax(tablica, polowa, N );
//        MinMax watek3 = new MinMax(czwarta, tablica2a);
//        MinMax watek4 = new MinMax(polowa - czwarta, tablica2b);

        watek1.setName("W1");
        //watek2.setName("W2");
//        watek3.setName("W3");
//        watek4.setName("W4");

        // Wypełniamy tablicę (można to zrobić przed uruchomieniem wątku)
        //watek.zapelnij();



        long startTime = System.nanoTime();
        // Uruchamiamy wątek (wątek zacznie wykonywać metodę run())
        watek1.start();
       // watek2.start();
//        watek3.start();
//        watek4.start();



        try {
            // Czekamy na zakończenie wątku
            watek1.join();
            //watek2.join();
//            watek3.join();;
//            watek4.join();;

            watek1.rysuj();
           // watek2.rysuj();
//            watek3.rysuj();
//            watek4.rysuj();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long durationNs = endTime - startTime;
        double durationMs = durationNs / 1_000_000.0; // Konwersja na milisekundy

        int Min1 = watek1.getMin();
        int Max1 = watek1.getMax();

       // int Min2 = watek2.getMin();
       // int Max2 = watek2.getMax();

//        int Min3 = watek3.getMin();
//        int Max3 = watek3.getMax();
//
//        int Min4 = watek4.getMin();
//        int Max4 = watek4.getMax();
        // zakonczenie pomiaru czasu



        System.out.println("min1: " + Min1 + " Max1: " + Max1 );
//        System.out.println("min3: " + Min3 + " Max3: " + Max3 + " min4: " + Min4 + " max4 " + Max4);
//
        // int MIN1 = Math.min(Min1, Min2);
//        int MIN2 = Math.min(Min3, Min4);
       // int MAX1 = Math.max(Max1, Max2);
//        int MAX2 = Math.max(Max3, Max4);

//        int MIN = Math.min(MIN1, MIN2);
//        int MAX = Math.max(MAX1, MAX2);
        System.out.println("MIN: " + Min1);
        System.out.println("MAX: " + Max1);

        System.out.println("Czas wyszukiwania min/max: " + durationNs + " ns");
        System.out.println("Czas wyszukiwania min/max: " + durationMs + " ms");


//
    }


}