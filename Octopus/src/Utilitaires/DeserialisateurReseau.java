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
     * @param serverSocket Le Socket utiliser pour communiquer avec la machine
     * qui envois la class serialiser.
     * @return l'object deserialiser.
     */ 
    public Object Deserialiser(ServerSocket serverSocket)
    {
        
        Object o = null;
        try
      {
          
         DataInputStream inReseau = new DataInputStream(serverSocket.getInputStream());
          
         ObjectInputStream in = new ObjectInputStream(inReseau);
         
         this.o = in.readObject();
         
         in.close();
         
         inReseau.close();
         
         //new DataOutputStream(serverSocket.getOutputStream());
         
      }catch(IOException i)
      {
         i.printStackTrace();
         return o;
      }
      
      return o;
    }
}