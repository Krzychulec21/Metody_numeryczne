import java.util.function.DoubleFunction;

public class MetodaTrapezow {

    private static final double DX = 0.0001;

    private static DoubleFunction<Double> derive(DoubleFunction<Double> f) {
        return (x) -> (f.apply(x + DX) - f.apply(x)) / DX;
    }

    public static double oblicz(DoubleFunction<Double> funkcja, double a, double b) {
        DoubleFunction<Double> f = funkcja;
        for (int i = 0; i < 2; i++) {
            f = derive(f);
        }
        double blad = -((double) 1/12)*Math.pow(b-a,3)*f.apply(1);
        double suma = ((b-a)/2)*(funkcja.apply(a)+ funkcja.apply(b)) + blad;


        return suma;
    }

    public static void main(String[] args) {
        DoubleFunction<Double> funkcja = x-> x * x - x + 1; // funkcja do całkowania
        double a = 1; // początek przedziału
        double b = 4; // koniec przedziału
        double wynik = oblicz(funkcja, a, b);
        System.out.println("Wynik: " + wynik);

    }
}
