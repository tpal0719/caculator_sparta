package Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://teamsparta.notion.site/Java-decda7a240094997a83d32154784e7cc
public class App {
    public static void main(String[] args) {

        Caculator caculator = new Caculator();
        Scanner sc = new Scanner(System.in);

        // (2) App에서 똑같이 동작!
        while (true) {

            System.out.print("원의 넓이를 계산할것인가요?");
            sc.nextLine();
            String CircleOrCal =  sc.nextLine();
            if (CircleOrCal.equals("네")) {
                System.out.print("원의 반지름을 입력하세요: ");
                double radius = sc.nextDouble();

                try {
                    caculator.calculateCircleArea(radius);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    caculator.inquiryResultsCircle();
                }

            }
            else{
                System.out.print("첫 번째 숫자를 입력하세요:");
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요:");
                int num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                String answer = "";
                try {
                    caculator.calculate(operator, num1, num2);
                } catch (CaculateException e) {
                    System.out.println(e.getMessage());
                } finally {
                    sc.nextLine();

                    // (4) 삭제메서드
                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    answer = sc.nextLine();
                    if(answer.equals("remove"))  caculator.removeResult();

                    // (5) 조회메서드
                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    answer = sc.nextLine();
                    if(answer.equals("inquiry")) caculator.inquiryResults();

                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    answer = sc.nextLine();
                }

                if (answer.equals("exit")) break;
            }

        }

    }
}

