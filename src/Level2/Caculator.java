package Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class Caculator{

    //(2) 결과저장
    Queue<String> saveQueue = new LinkedList<>();

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
        saveQueue.add(saveResult);


    }

}
