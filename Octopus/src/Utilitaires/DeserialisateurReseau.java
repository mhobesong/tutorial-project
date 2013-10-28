/**
 * DeserialisateurReseau
 * 
 * Cette Class s'occupe de la serialisation des objects et les envoyer sur sur
 * le reseau.
 */
package Utilitaires;

import java.io.*;
import java.net.*;

public class DeserialisateurReseau{
    
    /**
     * Deserialise un objet stoker sur le disque.
     * @param port Le port sur lequel recuperer l'objet a serialiser.
     * @return l'object deserialiser.
     */ 
    public static Object Deserialiser(int port)
    {
        
        Object o = null;
        ServerSocket serverSocket;
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
        try
      {
          Socket server = serverSocket.accept();
          DataInputStream inReseau = new DataInputStream(server.getInputStream());
          
         ObjectInputStream in = new ObjectInputStream(inReseau);
         
         this.o = in.readObject();
         
         in.close();
         
         inReseau.close();
         
         new DataOutputStream(server.getOutputStream());
         
      }catch(IOException i)
      {
         i.printStackTrace();
         return o;
      }
      
      return o;
    }
}