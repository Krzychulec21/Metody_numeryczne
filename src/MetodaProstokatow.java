import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;

public class MetodaProstokatow {

    public static double oblicz(DoubleFunction<Double> funkcja, double a, double b, int n) {
        double width = (b - a) / n;  // szerokość prostokąta
        double suma = 0.0;
        for (int i = 0; i < n; i++) {
            double x = a + i * width;  // lewy brzeg prostokąta
            suma += funkcja.apply(x) * width;  // pole prostokąta
        }
        return suma;
    }

    public static void main(String[] args) {
        DoubleFunction<Double> funkcja = x -> x*x;  // funkcja do całkowania
        double a = -1.0;  // początek przedziału
        double b = 1.0;  // koniec przedziału
        int n = 10000000;  // liczba prostokatow/przedzialow
        double wynik = oblicz(funkcja, a, b, n);
        System.out.println("Wynik: " + wynik);
    }
}
