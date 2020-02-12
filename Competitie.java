
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clasa in care se desfasoara competitia ce foloseste design patternul
 * observer. Dupa fiecare meci echipele sunt anuntate de noul lor loc
 * in clasament.
 */
public class Competitie
{
	String type;
	String gender;
	Clasament clasament;
	
	/**
	 * Instantiates a new Competitie.
	 *
	 * @param type   the type
	 * @param gender the gender
	 */
	public Competitie(String type, String gender)
	{
		this.type = type;
		this.gender = gender;
	}
	
	/**
	 * Adaugare echipe in lista.
	 *
	 * @throws Exception the exception
	 */
	void adaugareEchipeInLista() throws Exception
	{
		clasament = new Clasament();
		Database database = Database.getInstance();
		clasament.echipeInOrdineaAdaugarii = new ArrayList<>();
		String buffer;
		while ((buffer = database.cititor.linieNoua()) != null)
        {
        	Team echipa = database.getTeam(buffer);
            if(echipa.getGender().equals(this.gender) && echipa.getTeamType().contains(this.type))
			{
					this.clasament.echipeInOrdineaAdaugarii.add(echipa);
			}
        }
	}
	
	/**
	 * Adaugare echipe in clasament.
	 */
//observer
	void adaugareEchipeInClasament()
	{
		int pozitie = 0;
		for (Team echipa : clasament.echipeInOrdineaAdaugarii)
		{
			echipa.punctaj = 0;
			echipa.pozitieInClasament = pozitie;
			this.clasament.echipe.add(echipa);
		}
	}
	
	/**
	 * Calcul punctaj echipe.
	 */
	void calculPunctajEchipe()
	{
		Visitor calcul = new CalculPunctaj();
		for (Team echipa : clasament.echipeInOrdineaAdaugarii)
		{
			echipa.accept(calcul);
		}
	}
	
	/**
	 * Printeaza clasamentul.
	 *
	 * @throws IOException the io exception
	 */
	void printClasament() throws IOException
	{
		clasament.print();
	}
	
	/**
	 * Desfasurarea meciurilor dintre echipe.
	 */
	void desfasurare()
	{
		clasament.meciuri();
		clasament.updateClasament();
	}
	
	/**
	 * Print castigatori.
	 *
	 * @throws IOException the io exception
	 */
	void printCastigatori() throws IOException
	{
		final int numarPersoanePodium = 3;
		Database database = Database.getInstance();
		for (int i = 0; i < numarPersoanePodium; i++)
		{
			database.scriitor.println(clasament.echipe.get(i).getTeamName());
		}
		for (Team echipa : clasament.echipeInOrdineaAdaugarii)
		{
			database.scriitor.println("Echipa " + echipa.getTeamName() + " a ocupat locul " + echipa.pozitieInClasament);
		}
	}
	
	
}
