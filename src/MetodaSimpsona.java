import java.util.function.DoubleFunction;

public class MetodaSimpsona {

    private static final double DX = 0.0001;

    private static DoubleFunction<Double> derive(DoubleFunction<Double> f) {
        return (x) -> (f.apply(x + DX) - f.apply(x)) / DX;
    }

    public static double oblicz(DoubleFunction<Double> funkcja, double a, double b) {
        DoubleFunction<Double> f = funkcja;
        for (int i = 0; i < 4; i++) {
            f = derive(f);
        }

        double blad = -((double) 1/90)*Math.pow((b-a)/2,5)*f.apply(1);
        double suma = ((b-a)/6)*(funkcja.apply(a) + 4*funkcja.apply((a+b)/2) + funkcja.apply(b)) + blad;


        return f.apply(1);
    }

    public static void main(String[] args) {
        DoubleFunction<Double> funkcja = x-> x * x - x + 1; // funkcja do całkowania
        double a = 1; // początek przedziału
        double b = 4; // koniec przedziału
        double wynik = oblicz(funkcja, a, b);
        System.out.println("Wynik: " + wynik);
    }
}
