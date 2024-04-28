import javax.swing.text.html.parser.Parser;
import java.util.regex.Pattern;

public class Caculator{

    // (2 - 1)
    // 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우
    // 적합한 Exception 클래스를 생성하여 throw 합니다. (매개변수로 해당 오류 내용을 전달합니다.)
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    public double calculate(String operationInput, String firstInput,String secondInput) throws CaculateException{

        //연산자 기호가 잘 못 들어온 경우
      if(!Pattern.matches(OPERATION_REG, operationInput)){
          throw new CaculateException("연산자불일치");
      }
        //분모에 0이 들어오거나
      if(firstInput.equals("0")){
          throw new CaculateException("분모가 0이 들어오면 안됨");
      }

      return 0;
    }





}
