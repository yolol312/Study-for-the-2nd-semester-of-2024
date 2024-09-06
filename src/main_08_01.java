import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
    //게시판 페이징하기
    int getTotalPage(int totalwriting, int countbypage) {
        int totalpage = 0;
        if (totalwriting % countbypage == 0) {
            totalpage = totalwriting / countbypage;
        }
        else{
            totalpage = (totalwriting / countbypage) + 1;
        }
        return totalpage;
    }
    //자릿수 구하기
    int getDigitCount(int num) {
        int digit = 1;
        int digitCount = 0;
        while(num / digit >= 1){
            digitCount++;
            digit *= 10;
        }
        return digitCount;
    }
    // 글자 수 구하기
    int getCharCount(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' '){
                count++;
            }
        }
        return count;
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

        /* 1000미만 3, 5의 배수 총합
        int result = main.sum_3_5();
        System.out.println(result);
        */

        /* 페이징 하기
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalwriting = Integer.parseInt(st.nextToken());
        int countbypage = Integer.parseInt(st.nextToken());
        int totalpage = main.getTotalPage(totalwriting, countbypage);
        System.out.println(totalpage);
        */

        /* 자릿수 구하기
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        int num = Integer.parseInt(br.readLine());
        int result = main.getDigitCount(num);
        System.out.println(result);
        */

        // 글자 수 구하기
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        int count = main.getCharCount(br.readLine());
        System.out.println(count);
    }
}
