package Zad1a_;

import java.util.Random;

public class MinMax extends Thread{

    public int[] tablica;
    public int startIndex;
    public int koniecIndex;
    int min;
    int max;

    public MinMax(int[] tablica_, int startIndex_, int koniecIndex_) {
        this.startIndex = startIndex_;
        this.koniecIndex = koniecIndex_;
        this.tablica = tablica_;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }


    public void rysuj() {
        for (int i = startIndex; i < koniecIndex; i++) {
            System.out.println(Thread.currentThread().getName() + tablica[i] + " index " + i);

        }
    }



    public void run() {
        // rozpoczecie pomiaru czasu


//     int min = tablica[0];
//     int max = tablica[0];
        for (int i = startIndex; i < koniecIndex; i++) {
            if (tablica[i] < min) {
                min = tablica[i];
            }
            if (tablica[i] > max) {
                max = tablica[i];
            }

        }


    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


}