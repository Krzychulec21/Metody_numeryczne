import java.util.function.DoubleFunction;

public class Falsi {
    static int licznik = 0;
    private static final double DX = 0.0001;

    /**
     * @param f f(x), the function to derive
     * @return f'(x), the derivative of the f(x)
     */
    private static DoubleFunction<Double> derive(DoubleFunction<Double> f) {
        return (x) -> (f.apply(x + DX) - f.apply(x)) / DX;
    }

    public static void falsi(double a, double b, double epsil, DoubleFunction<Double> rownanie) {
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
        double x;
        if (c==b)
            x =a ;
        else x=b;
        while (Math.abs(func(rownanie, x)) >= epsil) {
            x = x - (func(rownanie,x)*(c-x))/(func(rownanie,c)-func(rownanie,x));
            licznik++;
        }
        System.out.println("x" + licznik + " = " + x);
    }

//    public static double[] pochodna(double[] rownanie) {
//        int n = rownanie.length;
//        double[] wspPochodnej = new double[n - 1];
//        for (int i = 1; i < n; i++) {
//            wspPochodnej[i - 1] = rownanie[i] * i;
//        }
//        return wspPochodnej;
//    }

    static double func(DoubleFunction<Double> f, double x) {
        return Math.round(f.apply(x));
    }


    public static void main(String[] args) {
       // double[] wspolczynniki = {1,-3,Math.log(4),2,-3,Math.sin(50)}; // wspolczynniki podowane sa w odwrotnej kolejnosci tzn. od wyrazu wolnego do najwyzszej potegi
        DoubleFunction<Double> cube = (x) -> (x+1)*(Math.pow((x-1),4));
        double a = -1.5; // the left end of the interval
        double b = -0.75; // the right end of the interval
        double epsilon = 0.01;
        falsi(a, b, epsilon, cube);
    }

}
