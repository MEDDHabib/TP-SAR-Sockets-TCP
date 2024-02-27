import java.io.*;
import java.net.*;

public class ServeurPersonne {
    public static void main(String[] args) {
        int port = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());

                int age = input.readInt();
                String nom = (String) input.readObject();

                int identifiantClient = (int) (Math.random() * 1000);

                output.writeInt(identifiantClient);
                output.flush();

                output.close();
                input.close();
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
