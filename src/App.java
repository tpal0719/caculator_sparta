import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        //(5) 결과를 저장할 맵
        int MaxIndex = 3;
        String[] strResult = new String[MaxIndex];
        int count = 0; //주소값

        Scanner sc = new Scanner(System.in);
        while (true) {
            // (1) 양의 정수 2개(0 포함)를 전달
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            // (2) 사칙연산 기호를 전달
            System.out.print("사칙연산 기호를 입력하세요: ");
            char type = sc.next().charAt(0);

            //(3) 연산을 진행한 후 결과값을 출력
            double result = switch (type) {
                case '+' -> {
                    yield num1 + num2;
                }
                case '-' -> {
                    yield num1 - num2;
                }
                case '*' -> {
                    yield num1 * num2;
                }
                //“나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. “
                case '/' -> {
                    if (num2 != 0) {
                        yield num1 / num2;
                    }
                    yield 0;
                }
                default -> {
                    System.out.println("잘못된 사칙연산");
                    yield 0;
                }
            };
            System.out.println(num1 + " " + type + " " + num2);
            System.out.println("결과: " + result);

            // (5) 결과를 String Array에 저장
            String saveResult = num1 + " " + type + " " + num2 + " = " + result;
            // (6) 연산 결과가 10개를 초과하는 경우
            // 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장 (string Array로 직접해봄)
            if (strResult[MaxIndex - 1] != null) {
                for (int i = 0; i < MaxIndex - 1; i++) {
                    strResult[i] = strResult[i + 1];
                }
                strResult[MaxIndex - 1] = saveResult;
            } else {
                strResult[count++] = saveResult;
            }


            // (4) “exit” 문자열을 입력하기 전까지 무한으로 계산
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            sc.nextLine(); //입력오류 해결
            String answer = sc.nextLine();

            if (answer.equals("exit")) {
                //(6) 확인용
                for (int i = 0; i < strResult.length; i++) {
                    System.out.println(strResult[i]);
                }
                break;
            }

        }

    }


}
