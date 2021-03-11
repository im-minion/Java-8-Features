package lambdas;

public class LambdasExpressionAndVariableCapture {
    public static void main(String[] args) {
        // A local variable that can be captured.
        int num = 10;
        MyFunc myLambda = (n) -> {
            // This use of num is OK. It does not modify num.
            int v = num + n; // Variable used in lambda expression should be final or effectively final

            // However, the following is illegal because it attempts
            // to modify the value of num.
            // num++;
            return v;
        };
        // num = 9; //if you uncomment this num is not effectively final so it gives CTE
        // IMP: num should be effectively final or final if it needs to be used inside  lambda.
    }
}

// An example of capturing a local variable from the enclosing scope.
interface MyFunc {
    int func(int n);
}