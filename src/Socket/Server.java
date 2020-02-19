/**
 * Socket dient als Connector, damit wir über das Netzwerk
 * kommunizieren können. Zugriff über Input- und Output-
 * Streams.
 *
 * Zum Absenden von BufferedWriter muss geflusht werden
 * Flushen passiert auch beim closen, hier wird aber auch der Socket geschlossen.
 * Das wollen wir jedoch oft noch nicht!
 */

package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8080);
            while(true) {
                Socket client = s.accept();
                new Thread(new CalculateThread(client)).start();
                // Der Thread arbeitet hier die Aufgaben ab, damit mehrere Aufgaben gleichzeitig erledigt werden können
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            return s;
        } catch (Exception e) {
            return "";
        }
    }

}
