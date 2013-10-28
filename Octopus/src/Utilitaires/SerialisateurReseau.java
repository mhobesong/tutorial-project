/**
 * SerialisateurReseau
 * 
 * Responsable de serialiser un objet et de l'envoyer sur le reseau.
 **/
import java.net.*;
import java.io.*;

public class SerialisateurReseau
{
    /**
     * Serialise un objet et le stoke sur le reseau.
     * @param o l'object a serialiser sur le disque.
     * @param nomServeur Le nom du serveur sur lequel envoyer l'objet serialiser.
     * @param port Le numero de port du serveur sur lequel envoyer l'objet
     * serialiser.
     */ 
   public static void serialiser(Object o, String nomServeur, int port)
   {
      try
      {
        
         Socket client = new Socket(serverName, port);
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