public class Metoda_stycznych {
    static void styczne(double a, double b, double epsilon) {
        if (func(a) * func(b) >= 0) {
            System.out.println("You have not assumed right a and b");
        }
        // Initialize result
        double c = a;
        int i = 0;

        while (Math.abs(func(c)) >= epsilon) {

            c = c -(func(c)/funcFirst(c)); //TODO: ma byc dzielone pzez pochodna funckji
            i++;

        }
        System.out.println("x" + i + " : " + c);
    }


    static double func(double x) {
        return (x+1)*(Math.pow((x-1),4));
    }
    static double funcFirst(double x) {
        return Math.pow((x-1), 3)*(5*x+3);
    }

    // Driver program
    public static void main(String[] args) {
        // Initial values assumed

        double a = -1.5; // the left end of the interval
        double b = -0.75; // the right end of the interval
        double epsilon = 0.00001;
        styczne(a, b, epsilon);
    }

}

