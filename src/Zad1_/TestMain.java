package Zad1_;

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
        // Podział na dwie połowy:
        int polowa = N / 2;
        int czwarta = polowa / 2;
        int osma = czwarta / 2;


        // Tworzymy obiekt MinMax (wątek)

//        MinMax watek1 = new MinMax(tablica, 0,czwarta);
//       MinMax watek2 = new MinMax(tablica, czwarta, polowa);
//      MinMax watek3 = new MinMax(tablica,polowa,polowa+czwarta);
//       MinMax watek4 = new MinMax(tablica,polowa +

        MinMax watek1 = new MinMax(tablica, 0,osma);
        MinMax watek2 = new MinMax(tablica,osma, czwarta);
        MinMax watek3 = new MinMax(tablica,czwarta , 3*osma);
        MinMax watek4 = new MinMax(tablica,3*osma, polowa);
        MinMax watek5 = new MinMax(tablica, polowa,polowa+osma);
        MinMax watek6 = new MinMax(tablica, polowa+osma, polowa+czwarta);
        MinMax watek7 = new MinMax(tablica,polowa+czwarta, polowa+3*osma);
        MinMax watek8 = new MinMax(tablica,polowa + 3*osma, N);


        watek1.setName("W1");
        watek2.setName("W2");
        watek3.setName("W3");
        watek4.setName("W4");

        long startTime = System.nanoTime();
        // Uruchamiamy wątek (wątek zacznie wykonywać metodę run())
        watek1.start();
        watek2.start();
        watek3.start();
        watek4.start();



        try {
            // Czekamy na zakończenie wątku
            watek1.join();
            watek2.join();
            watek3.join();;
            watek4.join();;

//            watek1.rysuj();
//            watek2.rysuj();
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

       int Min2 = watek2.getMin();
       int Max2 = watek2.getMax();

        int Min3 = watek3.getMin();
        int Max3 = watek3.getMax();

        int Min4 = watek4.getMin();
        int Max4 = watek4.getMax();
        // zakonczenie pomiaru czasu



        System.out.println("min1: " + Min1 + " Max1: " + Max1 + " Max2: " + Max2 + "Min2" + Min2);
       System.out.println("min3: " + Min3 + " Max3: " + Max3 + " min4: " + Min4 + " max4 " + Max4);
//
         int MIN1 = Math.min(Min1, Min2);
         int MAX1 = Math.max(Max1, Max2);
        int MIN2 = Math.min(Min3, Min4);

       int MAX2 = Math.max(Max3, Max4);

       int MIN = Math.min(MIN1, MIN2);
        int MAX = Math.max(MAX1, MAX2);
        System.out.println("MIN: " + MIN);
        System.out.println("MAX: " + MAX);

        System.out.println("Czas wyszukiwania min/max: " + durationNs + " ns");
        System.out.println("Czas wyszukiwania min/max: " + durationMs + " ms");


//
    }


}