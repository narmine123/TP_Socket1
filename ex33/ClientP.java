package ex33;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientP {

    public static void main(String argv[]) {

        String host = "localhost"; // Adresse IP ou nom d'hôte du serveur

        int port = 10000;
        try {
            Scanner scanner = new Scanner(System.in);

            // Crée un nouveau socket et se connecte au serveur distant en utilisant le nom
            // du serveur et le port spécifiés.
            Socket socket = new Socket(host, port);

            // Crée un flux de sortie d'objet pour envoyer des données à travers le socket.
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            // Crée un flux d'entrée d'objet pour recevoir des données à travers le socket.
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Saisir les informations du personne
            System.out.print("Entrez l'age de la personne");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Entrez le nom  de la personne");
            String nom = scanner.nextLine();

            // Envoyer les informations du personne vers le serveur
            output.writeInt(age);
            output.writeObject(nom);


            int newId = (int) input.readObject();
            System.out.println(" recu du serveur : l'id du personne est " + newId);
            socket.close();

        } catch (Exception e) {
            System.err.println("Erreur : " + e);
            // capture toutes les exceptions qui pourraient se produire lors de l'exécution
            // du code dans le bloc try et les affiche dans la console.
        }
    }

}
