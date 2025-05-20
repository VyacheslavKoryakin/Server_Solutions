package HW;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AsyncServTCP {

    public static void main(String[] args) {
        Server server = new Server("127.0.0.1", 8080);
        server.start();


    }
}

class Server {
    private ServerSocket serverSocket;
    private final String address;
    private final int port;

    public Server(String address, int port) {

        this.address = address;
        this.port = port;
    }

    private void handleClient(Socket clientSocket) {
        try {
            String response;
            InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(inputStream);

            String request = bufferedReader.readLine();

            System.out.println(request);

            String [] requestValues = request.split("/");
            int a = Integer.parseInt(requestValues[0]);
            int b = Integer.parseInt(requestValues[2]);
            int result =0;
            switch (requestValues[1]) {
                case "+": result = a + b;
                    break;
                case "-": result = a - b;
                    break;
                case "*": result = a * b;
                    break;
                case "/": result = a / b;

            }

            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
            response = String.valueOf(result);

            writer.write(response + "\r\n");

            writer.flush();


        } catch (IOException e) {
            System.err.println("Error handling client" + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                clientSocket.shutdownOutput();
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client");
            }

        }
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server started" + address + ":" + port);
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Connected to client" + clientSocket.getRemoteSocketAddress());
                    new Thread(() -> handleClient(clientSocket)).start();

                } catch (IOException e) {
                    System.err.println("Error accepting client connection" + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Error starting server" + e.getMessage());
        } finally {
            stop();
        }
    }

    public void stop() {
        if (serverSocket != null && !serverSocket.isClosed()) {
            try {
                serverSocket.close();
                System.out.println("server closed");
            } catch (IOException e) {
                System.err.println("Error closing server" + e.getMessage());
            }
        }
    }
}



