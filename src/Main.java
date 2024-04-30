import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n=10;
        int x = -4;

        long[] answer = new long[n];
        for(int i = 0; i < n; i++){
            answer[i] = (long) x*(i+1);
        }

        Arrays.stream(answer).asDoubleStream().forEach(System.out::println);
    }


}
