
package projetgescom;


public class MonPacket {
    String NomTraitement;
    boolean OkErreur;
    int NumErreur;
    String MessageErreur;
    String[] parametre;
    String[][] TableauParametre;
    
    TableDonneesPlus NetDonnees;
    TableDonneesPlus[][] NetDonneesPlus;
    
    String CodeConnexionMachine;
    String CodeConnexionUser;
    String NomMachine;
    String AdresseIpMachine;
    String PortConnexionMachine;
    String LoginUtilisateur;
    String NomUtilisateur;
    
    class TableDonneesPlus {
        int nbreLign;
        int nbreColone;
        Object[][] TDonnes;
    
}
}
