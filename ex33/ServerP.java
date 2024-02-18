package ex33;
import java.io.*;
import java.net.*;

public class ServerP{
    public static void main(String argv[]) {
        int port = 10000;

        try {

            // Crée un objet ServerSocket lié au port spécifié par l'utilisateur.
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serveur en attente de connexion sur le port " + port);

            int clientId = 5;

            while (true) {

                // Attend qu'une connexion soit établie depuis un client.Lorsqu'une connexion est acceptée, l'addresse ip est retournée
                Socket socket = serverSocket.accept();
                System.out.println("Client connecté depuis : " + socket.getInetAddress());
                System.out.println("Nouvelle connexion client : " + clientId);

                // Crée des flux d'entrée et de sortie pour envoyer et recevoir des objets sur le socket.
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                // Lire les informations du personne envoyé par le client
                int age = input.readInt();
                String nom = (String) input.readObject();
                System.out.println("Reçu du client de nom est" + nom + " avec un age de" + age + "avec un id" + clientId);

                // Le serveur envoie l'id spécifique à ce client
                output.writeObject(clientId);

                clientId++;
            }

        } catch (Exception e) {
            System.err.println("Erreur : " + e);
            // Attrape toute exception pouvant survenir pendant l'exécution du code et affiche un message d'erreur correspondant.

        }
    }

}

    

