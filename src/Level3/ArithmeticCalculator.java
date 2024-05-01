package Level3;

import Level3.Arithmetic.*;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.regex.Pattern;


public class ArithmeticCalculator<T> extends Caculator {

//    AddOperator ad = new AddOperator();
//    DivideOperator di = new DivideOperator();
//    MultiplyOperator mi = new MultiplyOperator();
//    SubtractOperator si = new SubtractOperator();
//    ModOperator mo = new ModOperator();



    ArithmeticCalculator(){

//        ad = new AddOperator();
//        di = new DivideOperator();
//        mi = new MultiplyOperator();
//        si = new SubtractOperator();

        setCalculatorLogQueue(new LinkedList<>());
    }


    Queue<String> CalculatorLogQueue = new LinkedList<>();

    public void setCalculatorLogQueue(Queue<String> calculatorLogQueue) {
        CalculatorLogQueue = calculatorLogQueue;
    }

    public Queue<String> getCalculatorLogQueue() {
        return CalculatorLogQueue;
    }

    private static final String OPERATION_REG = "[+\\-*/%]";
    private static final String NUMBER_REG = "^[0-9]*$";

    //(2) Generic
    public void calculate(char operationInput, T firstInput,T secondInput) throws CaculateException
    {
        double result = 0;

        // (1) enum
        if (Objects.equals(OperatorType.ADD.getOperatorType(), operationInput)) {
            result = new AddOperator().operate((double) firstInput, (double) secondInput);
        } else if (Objects.equals(OperatorType.SUB.getOperatorType(), operationInput)) {
            result = new SubtractOperator().operate((double) firstInput, (double) secondInput);
        } else if (Objects.equals(OperatorType.Multiply.getOperatorType(), operationInput)) {
            result = new MultiplyOperator().operate((double) firstInput, (double) secondInput);
        } else if (Objects.equals(OperatorType.Divide.getOperatorType(), operationInput)) {
            result = new DivideOperator().operate((double) firstInput, (double) secondInput);
        } else if (Objects.equals(OperatorType.Mod.getOperatorType(), operationInput)) {
            result = new ModOperator().operate((double) firstInput, (double) secondInput);
        } else {
            throw new CaculateException("연산자불일치");
        }


        // (3) 랃다, 스트림
//        double result = switch (operationInput) {
//            case '+' -> {
//                op = OperatorType.ADD;
//                yield ad.operate((Double)firstInput,(Double)secondInput);
//            }
//            case '-' -> {
//                op = OperatorType.SUB;
//                yield si.operate((Double)firstInput,(Double)secondInput);
//            }
//            case '*' -> {
//                op = OperatorType.Multiply;
//                yield mi.operate((Double)firstInput,(Double)secondInput);
//            }
//            case '/' -> {
//                if ((Double)secondInput == 0) {
//                    throw new CaculateException("분모가 0이 들어오면 안됨");
//                } else {
//                    op = OperatorType.Divide;
//                    yield di.operate((Double)firstInput,(Double)secondInput);
//                }
//            }
//            case '%'->{
//                if ((Double)firstInput == 0 ) {
//                    throw new CaculateException("분모가 0이 들어오면 안됨");
//                }
//                if ((Double)secondInput == 0 ) {
//                    throw new CaculateException("0으로 나눌수 없음");
//                }
//                op = OperatorType.Mod;
//                yield mo.operate((Double)firstInput,(Double)secondInput);
//            }
//            default -> {
//                //(1) 연산자 기호가 잘 못 들어온 경우
//                if(!Pattern.matches(OPERATION_REG, operationInput+"")){
//                    throw new CaculateException("연산자불일치");
//                }
//                yield 0;
//            }
//        }; //switch end


        String saveResult = firstInput + " " + operationInput + " " + secondInput + " = " + result;
        System.out.println(saveResult);
        CalculatorLogQueue.add(saveResult);

    }

    public void removeResult()
    {
        CalculatorLogQueue.remove();
    }

    public void inquiryResults() {
        CalculatorLogQueue.stream().forEach(value->System.out.println(value+"\n"));
    }

}
