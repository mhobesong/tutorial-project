/**
 * Deserialisateur
 * 
 * Cette Class s'occupe de la serialisation des object et leurs stockage sur
 * disque.
 */
package Utilitaires;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialisateur{
    
    /**
     * Deserialise un objet stoker sur le disque.
     * @param path le chemin sur disque ou le ficher a deserialiser est stoker. Par exemple :
     * "c:/undosier/unAutreDosier/objet.ext"
     * @return l'object deserialiser.
     */ 
    public static Object Deserialiser(String path)
    {
        Object o = null;
        try
      {
         FileInputStream fileIn = new FileInputStream(path);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         o = in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }
      
      return o;
    }
}/**
 * Deserialisateur
 * 
 * Cette Class s'occupe de la serialisation des object et leurs stockage sur
 * disque.
 */
package Utilitaires;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialisateur{
    
    /**
     * Deserialise un objet stoker sur le disque.
     * @param path le chemin sur disque ou le ficher a deserialiser est stoker. Par exemple :
     * "c:/undosier/unAutreDosier/objet.ext"
     * @return l'object deserialiser.
     */ 
    public static Object Deserialiser(String path)
    {
        Object o = null;
        try
      {
         FileInputStream fileIn = new FileInputStream(path);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         o = in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }
      
      return o;
    }
}