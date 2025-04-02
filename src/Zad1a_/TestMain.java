package Zad1a_;

import java.util.Arrays;
import java.util.Random;


public class TestMain {
    public static void main(String[] args) {

        int N = 20;

        int[] tablica = new int[N];

        Random random = new Random();
        for(int i = 0; i < N; i++) {

            int liczba = random.nextInt(200);
            tablica[i] = liczba;

        }
        // Podział na dwie połowy:
   int liczbaWatkow = 1;
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
//        MinMax watek1 = new MinMax(tablica, 0,czwarta);
//       MinMax watek2 = new MinMax(tablica, czwarta, polowa);
//      MinMax watek3 = new MinMax(tablica,polowa,polowa+czwarta);
//       MinMax watek4 = new MinMax(tablica,polowa +

//        MinMax watek1 = new MinMax(tablica, 0,osma);
//        MinMax watek2 = new MinMax(tablica,osma, czwarta);
//        MinMax watek3 = new MinMax(tablica,czwarta , 3*osma);
//        MinMax watek4 = new MinMax(tablica,3*osma, polowa);
//        MinMax watek5 = new MinMax(tablica, polowa,polowa+osma);
//        MinMax watek6 = new MinMax(tablica, polowa+osma, polowa+czwarta);
//        MinMax watek7 = new MinMax(tablica,polowa+czwarta, polowa+3*osma);
//        MinMax watek8 = new MinMax(tablica,polowa + 3*osma, N);


//        watek1.setName("W1");
//        watek2.setName("W2");
//        watek3.setName("W3");
//        watek4.setName("W4");

        long startTime = System.nanoTime();
        // Uruchamiamy wątek (wątek zacznie wykonywać metodę run())
        // 1. Uruchamiamy wszystkie wątki
        for (int i = 0; i < liczbaWatkow; i++) {
            watki[i].start();
        }

// 2. Czekamy na zakończenie wszystkich wątków
        for (int i = 0; i < liczbaWatkow; i++) {
            try {
                watki[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

// 3. Wywołujemy metodę rysuj() po zakończeniu wszystkich wątków
        for (int i = 0; i < liczbaWatkow; i++) {
            watki[i].rysuj();
        }



        //  Tworzymy tablice na min/max po zakończeniu wątków
        int[] MIN = new int[liczbaWatkow];
        int[] MAX = new int[liczbaWatkow];

        for (int i = 0; i < liczbaWatkow; i++) {
            MIN[i] = watki[i].getMin();
            MAX[i] = watki[i].getMax();
        }

        for (int i = 0; i < liczbaWatkow; i++) {
           System.out.print("min tablea :" + MIN[i] );
           System.out.println("max tbela: " + MAX[i]);
        }

//        int Min1 = watek1.getMin();
//        int Max1 = watek1.getMax();
//
//        int Min2 = watek2.getMin();
//        int Max2 = watek2.getMax();
//
//        int Min3 = watek3.getMin();
//        int Max3 = watek3.getMax();
//
//        int Min4 = watek4.getMin();
//        int Max4 = watek4.getMax();
//        // zakonczenie pomiaru czasu

        // 4️⃣ Znalezienie globalnego min i max
        int globalMin = Arrays.stream(MIN).min().getAsInt();
        int globalMax = Arrays.stream(MAX).max().getAsInt();

        long endTime = System.nanoTime();
        long durationNs = endTime - startTime;
        double durationMs = durationNs / 1_000_000.0; // Konwersja na

        System.out.println("Minimalna wartość: " + globalMin);
        System.out.println("Maksymalna wartość: " + globalMax);
//
//        System.out.println("min1: " + Min1 + " Max1: " + Max1 + " Max2: " + Max2 + "Min2" + Min2);
//        System.out.println("min3: " + Min3 + " Max3: " + Max3 + " min4: " + Min4 + " max4 " + Max4);
//
//        int MIN1 = Math.min(Min1, Min2);
//        int MAX1 = Math.max(Max1, Max2);
//        int MIN2 = Math.min(Min3, Min4);
//
//        int MAX2 = Math.max(Max3, Max4);
//
//        int MIN = Math.min(MIN1, MIN2);
//        int MAX = Math.max(MAX1, MAX2);
//        System.out.println("MIN: " + MIN);
//        System.out.println("MAX: " + MAX);

        System.out.println("Czas wyszukiwania min/max: " + durationNs + " ns");
        System.out.println("Czas wyszukiwania min/max: " + durationMs + " ms");


//
    }


}