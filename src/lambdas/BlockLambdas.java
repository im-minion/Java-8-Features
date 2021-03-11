package lambdas;

/*
 * Single expression lambda bodies are referred to as "expression bodies".
 * Lambdas that have expression bodies are sometimes called "expression lambdas".
 *
 * if right side of lambda needs to have multiple statements then it should be wrapped in block {}.
 * those lambdas called as block lambdas.
 *
 * */
public class BlockLambdas {
    public static void main(String[] args) {
        NumericFunc n = (val) -> {
            int res = 1;
            for (int i = 1; i <= val; i++) {
                res = i * res;
            }
            return res;
        };

        System.out.println("The factorial of 3 is " + n.func(3));
        System.out.println("The factorial of 5 is " + n.func(5));
    }
}

@FunctionalInterface
interface NumericFunc {
    int func(int n);
}
