package Level3;


import java.util.LinkedList;
import java.util.Queue;


public class CircleCalculator<T> extends Caculator {

    final double PI = 3.14159265358979323846;

    CircleCalculator(){
        setCircleLogQueue(new LinkedList<>());
    }

    Queue<String> CircleLogQueue = new LinkedList<>();
    public Queue<String> getCircleLogQueue() {
        return CircleLogQueue;
    }
    public void setCircleLogQueue(Queue<String> circleLogQueue) {
        CircleLogQueue = circleLogQueue;
    }

    // (2) Generic
    public double calculateCircleArea(T radius){

        double result = PI*(Double)radius*(Double)radius;
        String saveResult = "반지름이 "+radius+"이면, 원의넓이는 " + result+"이다";
        CircleLogQueue.add(saveResult);

        return result;
    }

    // (3) 랃다, 스트림
    public void inquiryResultsCircle()
    {
        CircleLogQueue.stream().forEach(value->System.out.println(value+"\n"));
    }

}
