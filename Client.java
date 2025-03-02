import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost"; // client Server address
        int port = 12345; //client Port number
        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to the server");

            //client Input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String userMsg;
            while (true) {
                System.out.print("Client: ");
                userMsg = userInput.readLine();
                output.println(userMsg); // client sending message to server

                String serverResponse = input.readLine(); // client getting response from the server
                System.out.println("Server: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}