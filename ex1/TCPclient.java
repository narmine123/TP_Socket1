import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
 public static void main(String argv[]) {
    int port = 0;
    String host = "";
    Scanner keyb = new Scanner(System.in);
    //Crée un objet Scanner pour la saisie utilisateur depuis la console.
    System.out.print("Nom du serveur : ");
    //Affiche le message demandant à l'utilisateur de saisir le nom du serveur.
    host = keyb.next();
    //Lit la saisie de l'utilisateur pour le nom du serveur et l'assigne à la variable host.
    System.out.print("Port du serveur : ");
    //Affiche le message demandant à l'utilisateur de saisir le port du serveur.
    
    try {
        port = keyb.nextInt();
    }catch (NumberFormatException e) {
        System.err.println("Le second paramètre n'est pas un entier.");
        System.exit(-1);
    }
    // Lit la saisie de l'utilisateur pour le port du serveur et l'assigne à la variable port, en gérant une exception si la saisie n'est pas un entier. 
    try {
        InetAddress adr = InetAddress.getByName(host);
        // Obtient une instance de InetAddress à partir du nom du serveur saisi par l'utilisateur.
        Socket socket = new Socket(adr, port);
        // Crée un nouveau socket et se connecte au serveur distant en utilisant l'adresse et le port spécifiés.
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        //Crée un flux de sortie d'objet pour envoyer des données à travers le socket.
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        // Crée un flux d'entrée d'objet pour recevoir des données à travers le socket.
        output.writeObject(new String("ma première socket"));
        // Envoie une chaîne de caractères au serveur via le flux de sortie d'objet.
        String chaine = (String) input.readObject();
        //Lit une chaîne de caractères provenant du serveur via le flux d'entrée d'objet.
        System.out.println(" recu du serveur : " + chaine);
        //Affiche la chaîne reçue du serveur.
        } catch (Exception e) {
        System.err.println("Erreur : " + e);
        //capture toutes les exceptions qui pourraient se produire lors de l'exécution du code dans le bloc try et les affiche dans la console.
        }
        }
        }