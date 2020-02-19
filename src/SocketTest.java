import java.io.*;

public class SocketTest {
    public static void main(String[] args) {
        try(PrintWriter pw = new PrintWriter(new FileWriter("src/readOnConsole.txt"));) {
            for (int i = 0; i < 10; i++) {
                pw.println(readConsole());
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Eingeben: ");
            return br.readLine();
        } catch (IOException e) {
            return "";
        }
    }

}