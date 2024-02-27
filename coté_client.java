import java.io.*;
import java.net.*;
import java.util.Scanner;

class SocketClient {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);
        // Demande à l'utilisateur le nom du serveur
        System.out.print("Nom du serveur : ");
        host = keyb.next();
        // Demande à l'utilisateur le port du serveur
        System.out.print("Port du serveur : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1);
        }
        try {
            // Résout l'adresse IP du serveur à partir de son nom d'hôte
            InetAddress adr = InetAddress.getByName(host);
            // Établit la connexion avec le serveur en utilisant l'adresse IP et le port spécifiés
            Socket socket = new Socket(adr, port);
            // Configure les flux d'entrée et de sortie pour la communication avec le serveur
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            // Envoie un message au serveur
            output.writeObject(new String("ma première socket"));
            // Lit la réponse du serveur
            String chaine = (String) input.readObject();
            System.out.println(" recu du serveur : " + chaine);
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
