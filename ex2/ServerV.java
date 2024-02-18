import java.io.*;
import java.net.*;

public class ServerV {
    public static void main(String argv[]) {
        int port = 10000;

        try {

            // Crée un objet ServerSocket lié au port spécifié par l'utilisateur.
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serveur en attente de connexion sur le port " + port);

            // Attend qu'une connexion soit établie depuis un client.Lorsqu'une connexion
            // est acceptée, l'addresse ip est retournée
            Socket socket = serverSocket.accept();
            System.out.println("Client connecté depuis : " + socket.getInetAddress());

            // Crée des flux d'entrée et de sortie pour envoyer et recevoir des objets sur
            // le socket.

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            voiture voiture = (voiture) input.readObject();
            System.out.println("Reçu du client : " + voiture.getCarburant() + " litres de carburant.");

            // Modifier la quantité de carburant côté serveur
            voiture.setCarburant(500);
            // Envoie la voiture modifiée au client
            output.writeObject(voiture);

        } catch (Exception e) {
            System.err.println("Erreur : " + e);
            // Attrape toute exception pouvant survenir pendant l'exécution du code et
            // affiche un message d'erreur correspondant.

        }
    }
}