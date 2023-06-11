import java.util.Scanner;

public class LagrangePolynomial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("Podaj ilosc wezlow interpolacji: ");
        n = input.nextInt();

        var tab = new double[2][n];

        for (int i=0; i<n; i++) {
            System.out.print("Podaj x" + (i+1) + ": ");
            tab[0][i] = input.nextDouble();

            System.out.print("Podaj y" + (i+1) + ": ");
            tab[1][i] = input.nextDouble();
        }

        System.out.println();

        for (int i=0;i<2;i++) {
            for (int j=0;j<n;j++) {
                System.out.print(tab[i][j] + "  \t");
            }
            System.out.println();
        }

        System.out.println();

        String formula = "";

        for (int i=0;i<n;i++) {
            if (i==0) formula += tab[1][i] + "*(";
            else formula += " + " + tab[1][i] + "*(";


            String body = "";
            double mianownik = 1;
            for (int j=0;j<n;j++) {
                if (j==i) continue;

                if (j==0 || (i==0 && j==1)) body += "(x-(" + tab[0][j] + "))";
                else body += "*(x- (" + tab[0][j] + "))";
                mianownik *= (tab[0][i] - tab[0][j]);
            }

            formula += "(" + body + ")" + "/(" + mianownik + ")";

            formula += ")";
        }

        System.out.println(formula);


    }
}