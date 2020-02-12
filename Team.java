
import java.util.ArrayList;

/**
 * Clasa abstracta care este mostenita de toate celelalte clase care
 * definesc un tip de echipa. Se foloseste de design patternul visitor
 * pentru a calcula puntajul fiecarei echipe in functie de tipul ei.
 */
public abstract class Team implements Comparable
{
	//enunt
	private String teamName;
	private String gender;
	private int numberOfPlayers;
	private ArrayList<Player> players;
	//factory
	private String teamType;
	double scor;
	int pozitieInClasament;
//clasament
	int punctaj;
	
	/**
	 * Functia specifica visitor care apeleaza functiile specifice
	 * functionalitatii fiecarei clase pentru a calcula
	 * punctajele.
	 *
	 * @param v interfata folosita
	 */
//elemente de visitor
	abstract void accept(Visitor v);
	
	
	@Override
	public String toString()
	{
		return "{" +
				"teamName: " + getTeamName() +
				", gender: " + getGender() +
				", numberOfPlayers: " + getNumberOfPlayers() +
				", players: " + getPlayers() +
				'}';
	}
	
	/**
	 * Creaza o echipa dupa un vector de Stringuri citit din fisier.
	 *
	 * @param token vectorul de stringuri citit din fisier
	 * @throws Exception the exception
	 */
	public void creareEchipa(String[] token) throws Exception
	{
		Database database = Database.getInstance();
		setPlayers(new ArrayList<>());
		
		setTeamName(token[1].trim());
		setGender(token[2].trim());
		setNumberOfPlayers(Integer.parseInt(token[3].trim()));
		for (int i = 0; i < getNumberOfPlayers(); i++)
		{
			String[] buffer = database.cititor.linieNoua().split(",");
			Player jucator = new Player(buffer[0].trim(), buffer[1].trim());
			this.getPlayers().add(jucator);
		}
	}
	//pentru a sorta echipele in clasament
	
	/**
	 * Functia compareTo a fost suprascrisa pentru a
	 * putea ordona echipele in clasament dupa numarul de puncte.
	 *
	 * @param echipa
	 * @return specific compareTo
	 */
	public int compareTo(Object echipa)
	{
		if(this.punctaj < ((Team)echipa).punctaj)
		{
			return 1;
		} else if(this.punctaj > ((Team)echipa).punctaj)
		{
			return -1;
		} else
		{
			return 0;
		}
	}
	
	/**
	 * Gets team name.
	 *
	 * @return the team name
	 */
	public String getTeamName()
	{
		return teamName;
	}
	
	/**
	 * Sets team name.
	 *
	 * @param teamName the team name
	 */
	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}
	
	/**
	 * Gets team type.
	 *
	 * @return the team type
	 */
	public String getTeamType()
	{
		return teamType;
	}
	
	/**
	 * Sets team type.
	 *
	 * @param teamType the team type
	 */
	public void setTeamType(String teamType)
	{
		this.teamType = teamType;
	}
	
	/**
	 * Gets gender.
	 *
	 * @return the gender
	 */
	public String getGender()
	{
		return gender;
	}
	
	/**
	 * Sets gender.
	 *
	 * @param gender the gender
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	/**
	 * Gets players.
	 *
	 * @return the players
	 */
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	/**
	 * Sets players.
	 *
	 * @param players the players
	 */
	public void setPlayers(ArrayList<Player> players)
	{
		this.players = players;
	}
	
	/**
	 * Gets number of players.
	 *
	 * @return the number of players
	 */
	public int getNumberOfPlayers() { return numberOfPlayers; }
	
	/**
	 * Sets number of players.
	 *
	 * @param numberOfPlayers the number of players
	 */
	public void setNumberOfPlayers(int numberOfPlayers) { this.numberOfPlayers = numberOfPlayers; }
}
