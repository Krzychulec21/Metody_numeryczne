public class MetodaSipmsonaZlozona {
    // Funkcja, której całkę chcemy obliczyć
    public static double function(double x) {
        return x*x;
    }

    // Metoda obliczająca całkę metodą Simpsona dla jednego podprzedziału
    public static double simpson(double a, double b) {
        double h = (b - a) / 2.0;
        return (h / 3.0) * (function(a) + 4 * function(a + h) + function(b));
    }

    // Metoda obliczająca całkę metodą złożoną Simpsona
    public static double integrate(double a, double b, int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n must be an even number");
        }
        double h = (b - a) / n;
        double sum1 = 0.0;
        double sum2 = 0.0;
        for (int i = 1; i < n; i += 2) {
            double x = a + i * h;
            sum1 += function(x);
        }
        for (int i = 2; i < n-1; i += 2) {
            double x = a + i * h;
            sum2 += function(x);

        }
        return (h / 3.0) * (function(a)+function(b)+4*sum1+2*sum2);
    }

    // Przykładowe użycie
    public static void main(String[] args) {
        double a = -1.0; // Początek przedziału całkowania
        double b = 1.0; // Koniec przedziału całkowania
        int n = 10; // Liczba podprzedziałów (musi być parzysta)
        double result = integrate(a, b, n);
        System.out.println("Wynik: " + result);
    }
}
