/*
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder answer = new StringBuilder();
        while ((s=br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int base = 1;
            int cnt = 1;
            while ((base=base%n) != 0) {
                cnt++;
                base = base*10+1;
            }
            answer.append(cnt).append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _0910_ {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        StringBuilder answer = new StringBuilder();
        while ((input = br.readLine()) != null) {
            try {
                BigInteger bigNum = new BigInteger(input);

                BigInteger digit = BigInteger.ONE;
                BigInteger square = BigInteger.ONE;
                for (int i = 1;; i++) {
                    square = square.multiply(BigInteger.TEN);
                    digit = digit.add(square);
                    if (digit.mod(bigNum).equals(BigInteger.ZERO)) {
                        answer.append(i+1).append('\n');
                        break;
                    }
                }
            }
            catch(Exception e) {
                System.out.println(answer);
            }
        }
    }
}