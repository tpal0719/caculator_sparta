package FEEDBACK.Arithmetic;

import Level3.OperatorType;

public class AddOperator implements InterOperator {
    public double operate(double a, double b) {
        return a + b;
    }

    @Override
    public OperatorType getOperatorName() {
        return OperatorType.ADD;
    }
}
