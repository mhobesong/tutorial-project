/*
 * BaseModel
 * 
 * Cette classe offre le facilitées pour la connection à une base de donnée.
 * Toutes les class "Model" de l'application doivent hérité de cette classe.
 */
package Models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import org.ini4j.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author besong
 */
public class BaseModel {

    private String dbDriverName; // exemple "com.mysql.jdbc.Driver";
    private String jdbcUrl; //exemple "jdbc:mysql://localhost:3306/bd";
    
    /**
     * Une reference à la connection à la base de donnée.
     */
    private Connection connection ;
    
    private String SGBD;
    /** 
     * Le nom de la table lier à ce Model
     */
    protected String table;
    /**
     * La list des column de la table lier à ce Model
     */
    protected ArrayList tableColumns;

    public BaseModel() {
        try {
            this.connexion(this.getDBParameters());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the dbDriverName
     */
    public String getDbDriverName() {
        return dbDriverName;
    }

    /**
     * @param dbDriverName the dbDriverName to set
     */
    public void setDbDriverName(String dbDriverName) {
        this.dbDriverName = dbDriverName;
    }

    /**
     * @return the jdbcUrl
     */
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    /**
     * @param jdbcUrl the jdbcUrl to set
     */
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @return the SGBD
     */
    public String getSGBD() {
        return SGBD;
    }

    /**
     * getDBParameters Retourne les parametres de connexion à la base de donnée.
     *
     * @return ArrayList
     */
    private ArrayList getDBParameters() throws IOException {
        ArrayList params = new ArrayList();

        //On recupere les parametres de connexion à la base de donnée du fichier
        //Configuration/BD.ini
        Wini ini = new Wini(new File("src/octopus/Configuration/DB.ini"));

        String sgbd = ini.get("DEFAULT", "SGBD");
        this.SGBD = sgbd;

        params.add(ini.get(sgbd, "Host")); //params.get(0)
        params.add(ini.get(sgbd, "User"));//params.get(1)
        params.add(ini.get(sgbd, "PassWord"));//params.get(2)
        params.add(ini.get(sgbd, "Port"));//params.get(3)
        params.add(ini.get(sgbd, "Name"));//params.get(4)

        return params;
    }

    /**
     * Connecte l'application a une base de donnée
     *
     * @param params ArrayList contenant les parametres de connection à la base
     * de donnée. Les indexs du ArrayList sont organisés comme suit :
     * <ul>
     * <li>0=>host</li>
     * <li>1=>user</li>
     * <li>2=>passWord</li>
     * <li>3=>port</li>
     * <li>4=>name</li>
     * </ul>
     * @return 'true' si la connexion c'est bien passer. Sinon retourne 'false'.
     */
    private Connection connexion(ArrayList params) {
        
        Connection connection = null;
        
        //Recuperation des parametres de connexion pour un SGBD MYSQL.
        if ("MYSQL".equals(this.getSGBD())) {
            String host = (String) params.get(0);
            String user = (String) params.get(1);
            String passWord = (String) params.get(2);
            String port = (String) params.get(3);
            String name = (String) params.get(4);

            //Le pilote utiliser pour la connexion
            this.setDbDriverName("com.mysql.jdbc.Driver");

            //Construction de la chaîne de connexion
            this.setJdbcUrl("jdbc:mysql://" + user + "@" + host + ":" + port + "/" + name);

            //Connexion à la base de donnée
            try {
                Class.forName(getDbDriverName());
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException : " + e.getMessage());
                return connection;
            }

            try {
                connection = DriverManager.getConnection(this.getJdbcUrl(), "root", "");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return connection;
            }
        }
        this.connection = connection;
        return connection;
    }
}
