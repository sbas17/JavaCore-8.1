import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main (String[] args) {
        int port = 8089;
        try (Socket clientSocket = new Socket(InetAddress.getLocalHost(), port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("GET / HTTP/1.1\n" +
                        "Host: localhost\n\n\n");

            String resp = in.readLine();
            System.out.println(resp);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
