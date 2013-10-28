/**
 * SerialisateurReseau
 * 
 * Responsable de serialiser un objet et de l'envoyer sur le reseau.
 **/
 
 package Utilitaires;
 
import java.net.*;
import java.io.*;

public class SerialisateurReseau
{
    /**
     * Serialise un objet et le stoke sur le reseau.
     * @param o l'object a serialiser sur le disque.
     * @param client Le Socket utiliser par la machine client pour communiquer
     * avec la machine qui recois l'objet serialiser.
     */ 
   public void serialiser(Object o, Socket client)
   {
      try
      {
        
         OutputStream outToServer = client.getOutputStream();
         
         ObjectOutputStream out = new ObjectOutputStream(outToServer);
         out.writeObject(o);
         
         
         out.close();
         
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}