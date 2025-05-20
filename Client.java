package HW;

import java.io.*;
import java.net.*;

public class Client {


    public static void main(String[] args) throws IOException {
        String message;
        int a = 5;
        int b = 10;
        char operation = '*';
        String ipAddress = "127.0.0.1";
        int port = 8080;
        BufferedReader reader;
        PrintWriter writer;

        Socket socket = new Socket();
        try {
            InetAddress ip = InetAddress.getByName(ipAddress);
            socket.connect((new InetSocketAddress(ip, port)));

            if (socket.isConnected()) {
                System.out.println("Connected to server");
                writer = new PrintWriter(socket.getOutputStream());
                writer.write(a + "/" + operation + "/" + b+"\n");
                writer.flush();





                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


                while ((message = reader.readLine())!=null)  {


                    System.out.println("Received: " + message);


                }

            } else {
                System.out.println("error not connection");


            }

        } finally {
            if (socket != null) {
                try {
                    socket.shutdownInput();
                    socket.shutdownOutput();
                    socket.close();
                    System.out.println("connection closed");
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("error shutdown input");
                }
            }
        }


    }
}


