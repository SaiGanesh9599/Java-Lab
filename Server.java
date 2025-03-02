import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345; //serevr Port number
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            Socket socket = serverSocket.accept(); // server accepting client connection
            System.out.println("Client connected");

            //server Input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String clientsmsg;
            while ((clientsmsg = input.readLine()) != null) {
                System.out.println("Client: " + clientsmsg);
                System.out.print("Server: ");
                String response = userInput.readLine();
                output.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}