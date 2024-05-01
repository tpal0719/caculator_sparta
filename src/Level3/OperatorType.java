package Level3;

//(1)
public enum OperatorType {

    ADD('+'),
    SUB('-'),
    Multiply('*'),
    Divide('/'),
    Mod('%');

    private final char operatorType;

    OperatorType(char c) {
        this.operatorType = c;
    }

    public char getOperatorType() {
        return operatorType;
    }
}
