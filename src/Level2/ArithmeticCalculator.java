package Level2;

import Level2.Arithmetic.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

// (8)
public class ArithmeticCalculator extends Caculator{

    AddOperator ad = new AddOperator();
    DivideOperator di = new DivideOperator();
    MultiplyOperator mi = new MultiplyOperator();
    SubtractOperator si = new SubtractOperator();

    ArithmeticCalculator(){
        // (9) 연산 클래스 분리
        ad = new AddOperator();
        di = new DivideOperator();
        mi = new MultiplyOperator();
        si = new SubtractOperator();

        setCalculatorLogQueue(new LinkedList<>());
    }

    // (2) 결과저장
    Queue<String> CalculatorLogQueue = new LinkedList<>();
    // (3) Getter Setter 구현 (캡슐화)
    public Queue<String> getCalculatorLogQueue() {
        return CalculatorLogQueue;
    }
    public void setCalculatorLogQueue(Queue<String> calculatorLogQueue) {
        this.CalculatorLogQueue = calculatorLogQueue;
    }


    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    public void calculate(char operationInput, int firstInput,int secondInput) throws CaculateException
    {
        double result = switch (operationInput) {
            case '+' -> {
                yield ad.operate(firstInput,secondInput);
            }
            case '-' -> {
                yield si.operate(firstInput,secondInput);
            }
            case '*' -> {
                yield mi.operate(firstInput,secondInput);
            }
            case '/' -> {
                if (secondInput == 0) {
                    throw new CaculateException("분모가 0이 들어오면 안됨");
                } else {
                    yield di.operate(firstInput,secondInput);
                }
            }
            default -> {
                //(1) 연산자 기호가 잘 못 들어온 경우
                if(!Pattern.matches(OPERATION_REG, operationInput+"")){
                    throw new CaculateException("연산자불일치");
                }
                yield 0;
            }
        }; //switch end

        //(2) 결과저장
        String saveResult = firstInput + " " + operationInput + " " + secondInput + " = " + result;
        System.out.println(saveResult);
        CalculatorLogQueue.add(saveResult);


    }

    // (4) 가장 오래된 저장데이터 remove
    public void removeResult()
    {
        CalculatorLogQueue.remove();
    }

    // (5) 저장된 연산들 조회
    public void inquiryResults() {
        CalculatorLogQueue.stream().forEach(value->System.out.println(value+"\n"));
    }

}
