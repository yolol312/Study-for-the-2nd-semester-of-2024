import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class main_08_01 {
    public void gugu(int num) {
        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %d%n", num, i, num * i);
            System.out.print("GUGU");
        }
    }
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        int num = Integer.parseInt(br.readLine());

        main_08_01 main = new main_08_01();
        main.gugu(num);
    }
}
