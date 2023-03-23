public class Falsi {
    static int licznik = 0;

    public static void falsi(double a, double b, double epsil, double[] rownanie) {
        if (func(rownanie, a) * func(rownanie, b) >= 0) {
            throw new IllegalArgumentException("Wartosci na koncach przedzialu sa takie same!");
        }
        double[] f1 = pochodna(rownanie);
        double[] f2 = pochodna(f1);
        double c;
        if (func(f1, a) * func(f2, a) >= 0) {
            c = a;
        } else if (func(f1, b) * func(f2, b) >= 0) {
            c = b;
        } else if (func(rownanie, a) * func(f2, a) >= 0) {
            c = a;
        } else if (func(rownanie, b) * func(f2, b) >= 0) {
            c = b;
        } else {
            throw new IllegalArgumentException("Error");
        }
        while (Math.abs(func(rownanie, c)) >= epsil) {
            c = c - (func(rownanie, c) / func(f1, c));
            licznik++;
        }

        System.out.println("x"+licznik+" = "+c);

//        System.out.println(func(rownanie, a));
//        System.out.println(func(f1, a));
//        System.out.println(func(f2, a));

    }

    public static double[] pochodna(double[] rownanie) {
        int n = rownanie.length;
        double[] wspPochodnej = new double[n - 1];
        for (int i = 1; i < n; i++) {
            wspPochodnej[i - 1] = rownanie[i] * i;
        }
        return wspPochodnej;
    }


    static double func(double[] wspolczynniki, double x) {
        double wartosc = 0;
        for (int i = 0; i < wspolczynniki.length; i++) {
            wartosc += wspolczynniki[i] * Math.pow(x, i);
        }
        return wartosc;
    }


    public static void main(String[] args) {
        double[] wspolczynniki = {1,-3,2,2,-3,1}; // wspolczynniki podowane sa w odwrotnej kolejnosci tzn. od wyrazu wolnego do najwyzszej potegi
        double a = -1.5; // the left end of the interval
        double b = -0.75; // the right end of the interval
        double epsilon = 0.000001;
        falsi(a, b, epsilon, wspolczynniki);


    }
}
