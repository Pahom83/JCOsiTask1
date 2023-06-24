package netology.ru.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final static int port = 8080;

    public static void main(String[] args){
        try (ServerSocket serverSocket = new ServerSocket(port)){ //Создаем серверный сокет
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted");
            output.println(String.format("Hi %s, your port is %d", input.readLine(), clientSocket.getPort()));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
