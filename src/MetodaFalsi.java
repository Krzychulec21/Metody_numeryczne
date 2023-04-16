import java.util.Scanner;

public class MetodaFalsi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj lewą granicę przedziału: ");
        double a = scanner.nextDouble();
        System.out.print("Podaj prawą granicę przedziału: ");
        double b = scanner.nextDouble();
        System.out.print("Podaj dokładność obliczeń: ");
        double epsilon = scanner.nextDouble();

        double x;
        int iteracje = 0;

        do {
            double fa = funkcja(a);
            double fb = funkcja(b);
            double df = pochodnaPierwszegoStopnia(a, b);
            double d2f = pochodnaDrugiegoStopnia(a, b);
            x = (a * fb - b * fa) / (fb - fa);
            double fx = funkcja(x);
            double blad = Math.abs(fx);
            iteracje++;

            if (fx * fa < 0) {
                b = x;
            } else {
                a = x;
            }

            if (d2f == 0) {
                x = Double.NaN;
                break;
            }

        } while (Math.abs(funkcja(x)) > epsilon && iteracje < 1000);

        if (!Double.isNaN(x)) {
            System.out.println("Pierwiastek równania: " + x);
            System.out.println("Liczba iteracji: " + iteracje);
        } else {
            System.out.println("Nie udało się wyznaczyć pierwiastka równania.");
        }
    }

    public static double funkcja(double x) {
        // tu wpisz funkcję, której pierwiastek chcesz obliczyć
        return (x+1)*(Math.pow((x-1),4));
    }

    public static double pochodnaPierwszegoStopnia(double a, double b) {
        double h = 0.0001;
        return (funkcja(b) - funkcja(a)) / (b - a);
    }

    public static double pochodnaDrugiegoStopnia(double a, double b) {
        double h = 0.0001;
        return (funkcja(b + h) - 2 * funkcja(b) + funkcja(b - h)) / (h * h);
    }
}