package Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class Caculator{

    // (6) 생셩될때 초기화
    Caculator(){
        setSaveQueue(new LinkedList<>());
    }

    // (2) 결과저장
    Queue<String> saveQueue = new LinkedList<>();
    // (3) Getter Setter 구현 (캡슐화)
    public Queue<String> getSaveQueue() {
        return saveQueue;
    }
    public void setSaveQueue(Queue<String> saveQueue) {
        this.saveQueue = saveQueue;
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
        saveQueue.add(saveResult);


    }

    // (4) 가장 오래된 저장데이터 remove
    public void removeResult()
    {
        saveQueue.remove();
    }

    // (5) 저장된 연산들 조회
    public void inquiryResults() {
        saveQueue.stream().forEach(value->System.out.println(value+"\n"));
    }



}
