import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketServeur {
    public static void main(String argv[]) {
        int port = 10000;
        Scanner keyb = new Scanner(System.in);
        // crée un objet Scanner pour lire les entrées utilisateur depuis la console.

        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        } // Demande à l'utilisateur de saisir le port sur lequel le serveur écoutera.
          // S'il saisit un non-entier,
          // une exception est attrapée et un message d'erreur est affiché, expliquant
          // l'utilisation correcte du programme.

        try {

            ServerSocket serverSocket = new ServerSocket(port);
            // Crée un objet ServerSocket lié au port spécifié par l'utilisateur.

            Socket socket = serverSocket.accept();
            // Attend qu'une connexion soit établie depuis un client.Lorsqu'une connexion
            // est acceptée, un objet `Socket` est retourné.

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            // Crée des flux d'entrée et de sortie pour envoyer et recevoir des objets sur
            // le socket.

            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine);
            // Lit une chaîne envoyée par le client à travers le socket, puis affiche cette
            // chaîne sur la console.

            System.out.println(" ca vient de : " + socket.getInetAddress() + ":" + socket.getPort());
            // Affiche l'adresse IP et le port du client à partir duquel la connexion a été
            // reçue.

            output.writeObject(new String("bien recu"));
            // Envoie une confirmation au client que le message a été bien reçu.
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
            // Attrape toute exception pouvant survenir pendant l'exécution du code et
            // affiche un message d'erreur correspondant.

        }
    }
}