import java.io.*;
import java.net.*;

class ClientV {
    public static void main(String argv[]) {

        String host = "localhost"; // Adresse IP ou nom d'hôte du serveur

        int port = 10000;
        try {

            // Crée un nouveau socket et se connecte au serveur distant en utilisant le nom
            // du serveur et le port spécifiés.
            Socket socket = new Socket(host, port);

            // Crée un flux de sortie d'objet pour envoyer des données à travers le socket.
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            // Crée un flux d'entrée d'objet pour recevoir des données à travers le socket.
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Créer une voiture et l'envoyer au serveur
            voiture maVoiture = new voiture("SUV", "Toyota RAV4");
            output.writeObject(maVoiture);

            // Lire la voiture modifiée du serveur
            voiture newvoiture = (voiture) input.readObject();
            System.out.println(" recu du serveur : " + newvoiture.getCarburant());
            socket.close();

        } catch (Exception e) {
            System.err.println("Erreur : " + e);
            // capture toutes les exceptions qui pourraient se produire lors de l'exécution
            // du code dans le bloc try et les affiche dans la console.
        }
    }
}