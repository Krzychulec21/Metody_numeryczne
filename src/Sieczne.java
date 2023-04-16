import java.util.function.DoubleFunction;

public class Sieczne {
    static int licznik = 1;
    private static final double DX = 0.0001;

    private static DoubleFunction<Double> derive(DoubleFunction<Double> f) {
        return (x) -> (f.apply(x + DX) - f.apply(x)) / DX;
    }

    public static void sieczne(double a, double b, double epsil, DoubleFunction<Double> rownanie) {
        if (func(rownanie, a) * func(rownanie, b) >= 0) {
            throw new IllegalArgumentException("Wartosci na koncach przedzialu sa takie same!");
        }
        DoubleFunction<Double> f1 = derive(rownanie);
        DoubleFunction<Double> f2 = derive(f1);
        double x0 = a;
        if (func(f1, a) * func(f2, a) >= 0) {
            x0 = a;
        }
        if (func(f1, b) * func(f2, b) >= 0) {
            x0 = b;
        }

        if (func(f1, b) * func(f2, b) >= 0 && func(f1, a) * func(f2, a) >= 0) {
            if (func(rownanie, a) * func(f2, a) >= 0) {
                x0 = a;
            }
            if (func(rownanie, b) * func(f2, b) >= 0) {
                x0 = b;
            }
        }
        double x1;
        double xn;
        if (x0 == b) {
            x1 = a;
        } else {
            x1 = b;
        }
        do {
            xn = x1 - (func(rownanie, x1) * (x1 - x0)) / (func(rownanie, x1) - func(rownanie, x0));
            x0 = x1;
            x1 = xn;
            licznik++;
        } while (Math.abs(func(rownanie, xn)) >= epsil);
        System.out.println("x" + licznik + " = " + xn);
    }

    public static double[] pochodna(double[] rownanie) {
        int n = rownanie.length;
        double[] wspPochodnej = new double[n - 1];
        for (int i = 1; i < n; i++) {
            wspPochodnej[i - 1] = rownanie[i] * i;
        }
        return wspPochodnej;
    }

    static double func(DoubleFunction<Double> f, double x) {
        return (f.apply(x));
    }


    public static void main(String[] args) {
        double[] wspolczynniki = {-7, -4, -2, 1}; // wspolczynniki podowane sa w odwrotnej kolejnosci tzn. od wyrazu wolnego do najwyzszej potegi
        DoubleFunction<Double> cube = (x) -> (x + 1) * (Math.pow((x - 1), 4));
        double a = -1.5; // the left end of the interval
        double b = -0.75; // the right end of the interval
        double epsilon = 0.01;
        sieczne(a, b, epsilon, cube);
    }

}
