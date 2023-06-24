package netology.ru.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    final static int port = 8080;
    final static String host = "localhost";
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter output = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            output.println("""
                    Server-Client
                    Host: localhost


                    """);
            System.out.println(input.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}