import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketServeur {
    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);
        // Demande à l'utilisateur le port d'écoute
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }
        try {
            // Crée une instance de ServerSocket pour écouter sur le port spécifié
            ServerSocket serverSocket = new ServerSocket(port);
            // Accepte les connexions entrantes des clients
            Socket socket = serverSocket.accept();
            // Configure les flux d'entrée et de sortie pour la communication avec le client
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            // Lit l'objet entrant du client
            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine);
            // Affiche la source du message (adresse et port du client)
            System.out.println(" ca vient de : " + socket.getInetAddress() + ":" + socket.getPort());
            // Envoie un accusé de réception de retour au client
            output.writeObject(new String("bien recu"));
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
