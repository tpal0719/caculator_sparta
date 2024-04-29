package Level2;

import java.util.LinkedList;
import java.util.Queue;

// (8)
public class CircleCalculator extends Caculator{

    CircleCalculator(){
        setCircleLogQueue(new LinkedList<>());
    }


    final double PI = 3.14159265358979323846; // (7) final = 원주율은 불변이기 때문에

    // (7)
    Queue<String> CircleLogQueue = new LinkedList<>();
    public Queue<String> getCircleLogQueue() {
        return CircleLogQueue;
    }
    public void setCircleLogQueue(Queue<String> circleLogQueue) {
        CircleLogQueue = circleLogQueue;
    }

    // (7) 원넓이 계산
    public double calculateCircleArea(double radius){

        double result = PI*radius*radius;
        String saveResult = "반지름이 "+radius+"이면, 원의넓이는 " + result+"이다";
        //System.out.println(saveResult);
        CircleLogQueue.add(saveResult);

        return result;
    }

    // (7) 원넓이 조회
    public void inquiryResultsCircle()
    {
        CircleLogQueue.stream().forEach(value->System.out.println(value+"\n"));
    }

}
