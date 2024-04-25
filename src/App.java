import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char type = sc.next().charAt(0);



        double result = switch (type){
            case '+' -> {yield num1 + num2;}
            case '-' -> {yield num1 - num2;}
            case '*' -> {yield num1 * num2;}
            //“나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. “
            case '/' -> {
                if(num2!=0){
                    yield num1 / num2;
                }
                yield 0;
            }
            default -> {System.out.println("잘못된 사칙연산"); yield 0;}
        };
        System.out.println(num1+" "+type+" "+num2);
        System.out.println("결과: " + result);
    }
}
