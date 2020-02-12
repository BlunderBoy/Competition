
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clasa care foloseste desing patternul Singleton.
 * Design patternul se bazeaza pe crearea o singura data a unui obiect.
 * Obiectul poate fi accesat global prin functia getInstance.
 * Cand dau getInstance pe un obiect de tip database returnez de fapt obiectul meu.
 * Obiectul se foloseste ca unul normal numai ca am acces global la el.
 * Database tine in ea toate echipele si cititorul.
 */
public final class Database  {
    
    ArrayList<Team> echipe;
    Citire cititor;
   
    Scriere scriitor;
	
    private Database()
    {
	    echipe = new ArrayList<>();
    }
    
    private static class DatabaseHolder {
        public static final Database instance = new Database();
    }
    
    /**
     * Accesul global la Database.
     *
     * @return the instance
     */
    public static Database getInstance() {
        return DatabaseHolder.instance;
    }
    
    /**
     * Add echipa.
     *
     * @param echipa echipa
     */
    void addEchipa(Team echipa)
    {
        echipe.add(echipa);
    }
    
    /**
     * Seteaza folderul pentru citire.
     *
     * @param fisier fisier
     * @throws FileNotFoundException the file not found exception
     */
    void setFolderCitire(String fisier) throws FileNotFoundException
    {
        cititor = new Citire(fisier);
    }
    
    /**
     * Populare echipe.
     *
     * @throws Exception the exception
     */
    void populareEchipe() throws Exception
    {
        String buffer;
        String[] token;
        TeamFactory factory = new TeamFactory();
        while ((buffer = cititor.linieNoua()) != null)
        {
            token = buffer.split(",");
            Team echipa = factory.getTeam(token[0].trim());
            echipa.creareEchipa(token);
            addEchipa(echipa);
        }
    }
    
    /**
     * Returneaza o echipa din database dupa nume.
     *
     * @param nume the nume
     * @return the team
     */
    Team getTeam(String nume)
    {
        for (Team echipa : echipe)
        {
            if(nume.equals(echipa.getTeamName()))
            {
                return echipa;
            }
        }
        return null;
    }
    
    /**
     * Print.
     *
     * @throws IOException the io exception
     */
//debug
    void print() throws IOException
    {
        for (Team team : echipe)
        {
            scriitor.println(team.toString());
        }
    }
    
    /**
     * Sets folder scriere.
     *
     * @param fisier the fisier
     * @throws IOException the io exception
     */
//afisare
    void setFolderScriere(String fisier) throws IOException
    {
        scriitor = new Scriere(fisier);
    }
    
    /**
     * Close scriitor.
     *
     * @throws IOException the io exception
     */
    void closeScriitor() throws IOException
    {
        scriitor.close();
    }
    
}
