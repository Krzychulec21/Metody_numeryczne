import java.util.function.DoubleFunction;

public class MetodaStycznych {
    static int licznik = 0;
    private static final double DX = 0.0001;

    private static DoubleFunction<Double> derive(DoubleFunction<Double> f) {
        return (x) -> (f.apply(x + DX) - f.apply(x)) / DX;
    }

    public static void styczne(double a, double b, double epsil, DoubleFunction<Double> rownanie) {
        if (func(rownanie, a) * func(rownanie, b) >= 0) {
            throw new IllegalArgumentException("Wartosci na koncach przedzialu sa takie same!");
        }
        DoubleFunction<Double> f1 = derive(rownanie);
        DoubleFunction<Double> f2 = derive(f1);
        double c = a;
        if (func(f1, a) * func(f2, a) >= 0) {
            c = a;
        }
        if (func(f1, b) * func(f2, b) >= 0) {
            c = b;
        }

        if (func(f1, b) * func(f2, b) >= 0 && func(f1, a) * func(f2, a) >= 0) {
            if (func(rownanie, a) * func(f2, a) >= 0) {
                c = a;
            }
            if (func(rownanie, b) * func(f2, b) >= 0) {
                c = b;
            }
        }
        while (Math.abs(func(rownanie, c)) >= epsil) {
            c = c - (func(rownanie, c) / func(f1, c));
            licznik++;
        }
        System.out.println("x" + licznik + " = " + c);
    }


    static double func(DoubleFunction<Double> f, double x) {
        return (f.apply(x));
    }


    public static void main(String[] args) {
        //double[] wspolczynniki = {-7, -4, -2, 1}; // wspolczynniki podowane sa w odwrotnej kolejnosci tzn. od wyrazu wolnego do najwyzszej potegi
        double a = -1.5; // the left end of the interval
        double b = -0.75; // the right end of the interval
        double epsilon = 0.01;
        DoubleFunction<Double> cube = (x) -> (x + 1) * (Math.pow((x - 1), 4));
        styczne(a, b, epsilon, cube);
    }

}
