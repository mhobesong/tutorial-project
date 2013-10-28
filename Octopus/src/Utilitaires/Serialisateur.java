/**
 * Serialisateur
 * 
 * Cette Class s'occupe de la serialisation des object et leurs stockage sur
 * disque.
 */
package Utilitaires;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialisateur{
    
    /**
     * Serialise un objet et le stoke sur le disque.
     * @param o l'object a serialiser sur le disque.
     * @param path le chemin sur disque ou stoker l'object. Par exemple :
     * "c:/undosier/unAutreDosier/objet.ext"
     */ 
    public static void Serialiser(Object o, String path)
    {
        
        try
        {
         FileOutputStream fileOut = new FileOutputStream(path);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(o);
         out.close();
         fileOut.close();
      }catch(IOException i)
      {
          i.printStackTrace();
      }
    }
}