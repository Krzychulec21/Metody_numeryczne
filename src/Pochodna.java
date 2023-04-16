import java.util.function.DoubleFunction;

public class Pochodna {
    private static final double DX = 0.0001;

    /**
     * @param f f(x), the function to derive
     * @return f'(x), the derivative of the f(x)
     */
    private static DoubleFunction<Double> derive(DoubleFunction<Double> f) {
        return (x) -> (f.apply(x + DX) - f.apply(x)) / DX;
    }
    public static void main(String[] args) {
        DoubleFunction<Double> cube = (x) -> Math.pow(x,2);
        DoubleFunction<Double> cubeDeriv = derive(cube);
        System.out.println((cubeDeriv.apply(3)));


    }
}
