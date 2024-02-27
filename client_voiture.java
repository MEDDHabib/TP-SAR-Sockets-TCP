import java.io.*;
import java.net.*;

public class ClientVoiture {
    public static void main(String[] args) {
        String serveurIP = "127.0.0.1"; 
        int port = 12345; 

        try {
            
            Socket socket = new Socket(serveurIP, port);

            
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            
            voiture voitureClient = new voiture("SUV", "Toyota");
            output.writeObject(voitureClient);
            System.out.println("Voiture envoyée au serveur.");

            
            voiture voitureModifiee = (voiture) input.readObject();
            System.out.println("Voiture modifiée reçue du serveur : " + voitureModifiee);

            output.close();
            input.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
