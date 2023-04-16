public class BisectionAlgorithm {

    static int i = 0;

    public static double bisection(double a, double b, double epsilon) {
        if (f(a) * f(b) >= 0) {
            throw new IllegalArgumentException("Function has same signs at end points");
        }

        double c = a;

        while (Math.abs(f(c)) >= epsilon) {
            c = (a + b) / 2.0;
            if (f(c) * f(a) < 0) {
                b = c;
            } else {
                a = c;
            }
            i++;
        }
        return c;
    }

    public static double f(double x) {
        // enter your function
        return (x + 1) * (Math.pow((x - 1), 4));
    }

    public static void main(String[] args) {
        double a = -1.5;  //the left end of the interval
        double b = -0.75;  // the rigt end of the interval
        double epsilon = 0.000001; //


        double result = bisection(a, b, epsilon);

        System.out.println("x" + i + ": " + result);
    }
}


