import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                 out.println("Serj");
                 String resp = null;
                 while (true){
                     resp = in.readLine();
                     if (resp.contains("Off")){
                         System.out.println(resp);
                         System.out.println("Server if off. Bye.");
                         break;
                     }
                     System.out.println(resp);
                     String output = scanner.nextLine();
                     out.println(output);
                 }
             } catch (IOException e){
            e.printStackTrace();
        }
    }
}
