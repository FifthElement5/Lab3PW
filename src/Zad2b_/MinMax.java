package Zad2b_;

public class MinMax extends Thread{

    public double[] tablica;
    public int startIndex;
    public int koniecIndex;
    double min;
    double max;



    public MinMax(double[] tablica_, int startIndex_, int koniecIndex_) {
        this.startIndex = startIndex_;
        this.koniecIndex = koniecIndex_;
        this.tablica = tablica_;
        this.min = Double.MAX_VALUE;
        this.max = Double.MIN_VALUE;
    }


    public void rysuj() {
        for (int i = startIndex; i < koniecIndex; i++) {
            System.out.println(Thread.currentThread().getName() + tablica[i] + " index " + i);

        }
    }



    public void run() {
        // rozpoczecie pomiaru czasu


        for (int i = startIndex; i < koniecIndex; i++) {
            if (tablica[i] < min) {
                min = tablica[i];
            }
            if (tablica[i] > max) {
                max = tablica[i];
            }

        }


    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }




}