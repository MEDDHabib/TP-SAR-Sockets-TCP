import java.io.*;
import java.net.*;

public class ClientPersonne {
    public static void main(String[] args) {
        String serveurIP = "127.0.0.1";
        int port = 12345;

        try {
            Socket socket = new Socket(serveurIP, port);

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            int age = 30;
            String nom = "Alice";
            output.writeInt(age);
            output.writeObject(nom);
            output.flush();

            int identifiantClient = input.readInt();
            System.out.println("Identifiant de client reçu du serveur : " + identifiantClient);

            output.close();
            input.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
