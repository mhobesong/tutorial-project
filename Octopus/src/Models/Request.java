/*
 * Responsable des envoyer de requettes à une base de donnée et de recupere
 * le/les resultats.
 */
package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
/**
 *
 * @author besong
 */
public class Request {
 
    /**
     * Reference à la connextion a la base de donnée.
     */
    private Connection connection;
    
    /**
     * 
     * @param connection La reference à la connexion à utiliser pour le requettes.
     */
    public Request(Connection connection)
    {
        this.connection = connection;
    }

     

     public ResultSet  query(String table, String query) { ResultSet resultSet = null;

     try{ Statement stm = this.getConnection().createStatement();

    resultSet = stm.executeQuery(query); } catch(SQLException e) { System.out.println(e.getMessage()); System.out.println(e.getStackTrace()); }

    return resultSet; }
    
    public ResultSet select(String table, String[] criteria)
    {
        ResultSet resultSet = null;
        
        int criteriaLength = criteria.length;
        
        String where = "";
        
        String query = "";
        
        
        for (int i = 1; i <= criteriaLength ; i++)
        {
            if(i != criteriaLength)
            {
                where += " " + criteria[i] + " and";
            }
            else
            {
                where += " " + criteria[i];
            }
        }
        
        query = "SELECT * FROM " + table + " WHERE " + where;
        
        try{
            Statement stm = this.getConnection().createStatement();
            
            resultSet = stm.executeQuery(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        
        return resultSet;
    }
    
    public ResultSet selectAll(String table)
    {
        ResultSet resultSet = null;
        
        String query = "SELECT * FROM " + table;
        
        try{
            Statement stm = this.getConnection().createStatement();
            
            resultSet = stm.executeQuery(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        
        return resultSet;
    }
    
    public ResultSet selectById(String table, int id)
    {
        ResultSet resultSet = null;
        
        String query = "SELECT * FROM " + table + " WHERE id = " + id;
        
        try{
            Statement stm = this.getConnection().createStatement();
            
            resultSet = stm.executeQuery(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        
        return resultSet;
    }
    
    
    public ResultSet selectJoin(String table1, String table2, String[] table1Fields, String[] table2Fields)
    {
        ResultSet resultSet = null;
        
        String where = "";
        
        if(table1Fields.length != table2Fields.length) return null;
        
        if("".equals(table1) || "".equals(table2)) return null;
        
        String query = "SELECT * FROM " + table1 +" , " + table2 + " WHERE ";
        
        for(int i = 1; i <= table1Fields.length ; i++)
        {
            if(i != table1Fields.length)
            {
                where += table1Fields + " = " + table2Fields + " and ";
            }
            else
            {
                where += table1Fields + " = " + table2Fields ;
            }
        }
        
        query += where;
        
        try{
            Statement stm = this.getConnection().createStatement();
            
            resultSet = stm.executeQuery(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        
        return resultSet;
    }

    /**
     * @return la connexion utiliser
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection la connexion à utiliser
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
}
