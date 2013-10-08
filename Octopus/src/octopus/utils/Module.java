
package octopus.utils;

import java.util.ArrayList;

/**
 *
 * @author besong
 */
public class Module {
    
    private int id;
    
    private String nom;
    
    private ArrayList listComposant;
    
    private Composant composantDefaut;
    
    public Module(int id, String nom, ArrayList listComposant, Composant composantDefaut)
    {
        this.id = id;
        this.nom = nom;
        this.listComposant = listComposant;
        this.composantDefaut = composantDefaut;
    }
    
    /**
     * Retourne l'id du module.
     * @return int.
     */
    public int getId()
    {
        return this.id;
    }
    
    /**
     * Retourne le nom du module.
     * @return String.
     */
    public String getNom()
    {
        return this.nom;
    }
    
    /**
     * Returne la liste des composants que constitue le module.
     * @return ArrayList.
     */
    public ArrayList getListeComposant()
    {
        return this.listComposant;
    }
    
    /**
     * Retourne le composant par defaut du module.
     * @return Composant.
     */
    public Composant getComposantDefaut()
    {
        return this.composantDefaut;
    }
    
}
