import java.io.*;
import java.net.*;

public class ServeurVoiture {
    public static void main(String[] args) {
        int port = 12345; 
        
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serveur en attente de connexion...");

           
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connexion établie avec le client.");

            
            ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());

            
            voiture voitureDuClient = (voiture) input.readObject();
            System.out.println("Voiture reçue du client : " + voitureDuClient);

          
            voitureDuClient.setCarburant(50); // Exemple : fixer 50 litres de carburant

           
            output.writeObject(voitureDuClient);
            System.out.println("Voiture modifiée envoyée au client.");

            
            output.close();
            input.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
