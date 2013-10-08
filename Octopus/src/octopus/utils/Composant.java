package octopus.utils;

import java.util.ArrayList;

/**
 * La Classe Composant.
 * Ell represent un composant d'un module.
 * Les composants sont les logiciels qui constitue un module. Elles declinent
 * les responsabiliées du module.
 * @author besong
 */
public class Composant {
    
    private int id;
    
    private ArrayList listOutput;
    
    private ArrayList listInput;
    
    private ArrayList aTraiter;
    
    private Module module;
    
    private String menu;
    
    private String sousMenu;
    
    public Composant(int id, ArrayList listOutput, ArrayList listInput, ArrayList aTraiter, Module module, String menu, String sousMenu)
    {
        
        this.id = id;
        this.listInput = listInput;
        this.listOutput = listOutput;
        this.module = module;
        this.aTraiter = aTraiter;
        this.menu = menu;
        this.sousMenu = sousMenu;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public ArrayList getListInput()
    {
        return this.listInput;
    }
    
    public ArrayList getListOutput()
    {
        return this.listOutput;
    }
    
    public ArrayList getATraiter()
    {
        return this.aTraiter;
    }
    
    public Module getModule()
    {
        return this.module;
    }
    
    public String getMenu()
    {
        return this.menu;
    }
    
    public String getSousMenu()
    {
        return this.sousMenu;
    }
    
}
