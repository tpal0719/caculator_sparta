package Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class Caculator{

    final double PI = 3.14159265358979323846; // (7) final = 원주율은 불변이기 때문에

    // (6) 생셩될때 초기화
    Caculator(){
        setCalculatorLogQueue(new LinkedList<>());
        setCircleLogQueue(new LinkedList<>());
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


    // (7)
    Queue<String> CircleLogQueue = new LinkedList<>();
    public Queue<String> getCircleLogQueue() {
        return CircleLogQueue;
    }
    public void setCircleLogQueue(Queue<String> circleLogQueue) {
        CircleLogQueue = circleLogQueue;
    }

    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    //연산 + 예외처리
    public void calculate(char operationInput, int firstInput,int secondInput) throws CaculateException
    {
        double result = switch (operationInput) {
            case '+' -> {
                yield firstInput + secondInput;
            }
            case '-' -> {
                yield firstInput - secondInput;
            }
            case '*' -> {
                yield firstInput * secondInput;
            }
            case '/' -> {
                if (secondInput == 0) {
                    throw new CaculateException("분모가 0이 들어오면 안됨");
                } else {
                    yield firstInput / secondInput;
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

    // (7) 원넓이 계산
    public double calculateCircleArea(double radius){

        double result = PI*radius*radius;
        String saveResult = "반지름이 "+radius+"이면, 원의넓이는 " + result+"이다";
        //System.out.println(saveResult);
        CircleLogQueue.add(saveResult);

        return result;
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

    // (7) 원넓이 조회
    public void inquiryResultsCircle()
    {
        CircleLogQueue.stream().forEach(value->System.out.println(value+"\n"));
    }



}
