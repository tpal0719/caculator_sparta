package Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://teamsparta.notion.site/Java-decda7a240094997a83d32154784e7cc
public class App {
    public static void main(String[] args) {

        Caculator caculator = new Caculator();

        Scanner sc = new Scanner(System.in);

        /* 반복문 시작 */
        System.out.print("첫 번째 숫자를 입력하세요:");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요:");
        int num2 = sc.nextInt();

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);

        caculator.calculate(operator, num1, num2);

    }
}

