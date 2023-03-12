public class BisectionAlgorithm {


        public static double bisection(double a, double b, double epsilon, int maxIterations) {
            if (f(a) * f(b) >= 0) {
                throw new IllegalArgumentException("Function has same signs at end points");
            }

            int iter = 0;
            double c = a;

            while ((b - a) >= epsilon && iter < maxIterations) {
                c = (a + b) / 2.0;

                if (f(c) == 0.0) {
                    break;
                }
                else if (f(c) * f(a) < 0) {
                    b = c;
                }
                else {
                    a = c;
                }
                iter++;
            }

            return c;
        }

        public static double f(double x) {
            // Wprowadź swoją funkcję nieliniową
            return x * x - 4 * x - 10;
        }

        public static void main(String[] args) {
            double a = -2.0;
            double b = 3.0;
            double epsilon = 0.0001;
            int maxIterations = 1000;

            double root = bisection(a, b, epsilon, maxIterations);

            System.out.println("Root: " + root);
        }
    }


