/*
 * BaseControler
 * 
 * Cette Class à la responsabilité de chosir la vue à afficher et de passer des
 * informations a cette vue. Tous les controler doivent hériter de celui ci.
 */
package Controlers;
/**
 *
 * @author besong
 */
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class BaseControler {
    
    public static String currentView = "";
    
    public BaseControler(){
        
        
    }
    
    /**
     * Permet de passer les Objets/variables à une vue et de chrager la vue.
     * @param view le nom de la vue à charger.
     * @param classes Les Class/Types des Objects/variables à passer à la vue.
     * @param params Les Objets/variables à passer à la vue. 
     * @return 'true' si la vue est charger avec succès et 'false' sinon.
     */
    public boolean loadView(String view, Class[] classes, Object[] params)
    {
        try { 
      Class c = Class.forName( view ); 
      Method m = c.getDeclaredMethod("draw", c);
      Object ret =  m.invoke( null, params ); 
      
    } catch ( ClassNotFoundException | NoSuchMethodException | IllegalAccessException e ) { 
      // Class.forName( ) can't find the class
        return false;
    } catch ( InvocationTargetException e4 ) { 
      // an exception occurred while invoking that method 
      System.out.println("Method threw an: " + e4.getTargetException( ) );
      return false;
    } 
        currentView = view;
        return true;
    }
    
    /**
     * Permet charger une vue.
     * @param view Le nom de la vue à afficher.
     * @return 
     */
    public boolean loadView(String view)
    {
        
        try
        {
        Class c = Class.forName("view");
        
        Method m = c.getMethod("draw", new Class [] { });
        
        m.invoke(null, null);
        
        }
        catch(ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        
        currentView = view;
        return true;
    }
}
