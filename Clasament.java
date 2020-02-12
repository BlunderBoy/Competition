

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Clasament
{
	ArrayList<Team> echipe;
	ArrayList<Team> echipeInOrdineaAdaugarii;
	
	public Clasament()
	{
		this.echipe = new ArrayList<>();
		this.echipeInOrdineaAdaugarii = new ArrayList<>();
	}
	
	void updateClasament()
	{
		Collections.sort(echipe);
		for (Team echipa : echipeInOrdineaAdaugarii)
		{
			update(echipa);
		}
	}
	void update(Team echipa)
	{
		int pozitie;
		pozitie = echipe.indexOf(echipa);
		pozitie++;
		echipa.pozitieInClasament = pozitie;
	}
	void print() throws IOException
	{
		Database database = Database.getInstance();
		for (Team echipa : echipe)
		{
			database.scriitor.println(echipa.toString());
		}
	}
	void meciDirect(Team EchipaA, Team EchipaB)
	{
		final int numarPuncteCastig = 3;
		final int numarPuncteEgal = 1;
		if(EchipaA.scor > EchipaB.scor)
		{
			EchipaA.punctaj += numarPuncteCastig;
		} else if(EchipaA.scor < EchipaB.scor)
		{	
			
			EchipaB.punctaj += numarPuncteCastig;
		} else
		{
			EchipaA.punctaj += numarPuncteEgal;
			
			EchipaB.punctaj += numarPuncteEgal;
		}
	}
	void meciuri()
	{
		for (int i = 0; i < echipe.size() - 1; i++)
		{
			for (int j = i + 1; j < echipe.size(); j++)
			{
				meciDirect(echipeInOrdineaAdaugarii.get(i), echipeInOrdineaAdaugarii.get(j));
			}
		}
	}
}
