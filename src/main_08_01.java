import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class main_08_01 {
    //입력받은 숫자의 단 출력하기
    void gugu(int num) {
        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %d%n", num, i, num * i);
        }
    }
    //1000 미만의 자연수에서 3과 5의 배수의 총합
    int sum_3_5 () {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if(i%3==0 || i%5==0) {
                sum += i;
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        main_08_01 main = new main_08_01();

        /* 입력받은 수의 단 출력
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        int num = Integer.parseInt(br.readLine());
        main.gugu(num);
        */

        int result = main.sum_3_5();
        System.out.println(result);
    }
}
