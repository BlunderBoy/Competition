
public class CalculPunctaj implements Visitor
{
	@Override
	public void calculPunctaj(BasketballTeam echipa)
	{
		double punctaj = 0;
		
		for (Player jucator : echipa.getPlayers())
		{
			punctaj += jucator.score;
		}
		punctaj /= echipa.getNumberOfPlayers();
		
		echipa.scor = punctaj;
	}
	
	@Override
	public void calculPunctaj(FootballTeam echipa)
	{
		double punctaj = 0;
		if ("masculin".equals(echipa.getGender()))
		{
			for (Player jucator : echipa.getPlayers())
			{
				if(punctaj <= jucator.score)
				{
					punctaj = jucator.score;
				}
			}
			for (Player jucator : echipa.getPlayers())
			{
					punctaj += jucator.score;
			}
			echipa.scor = punctaj;
		}
		else {
			punctaj = echipa.getPlayers().get(0).score;
			for (Player jucator : echipa.getPlayers())
				{
					if(punctaj > jucator.score)
					{
						punctaj = jucator.score;
					}
				}
				for (Player jucator : echipa.getPlayers())
				{
						punctaj += jucator.score;
				}
				echipa.scor = punctaj;
		}
	}
	
	@Override
	public void calculPunctaj(HandballTeam echipa)
	{
		
		if ("masculin".equals(echipa.getGender()))
		{
			double punctaj = 0;
			for (Player jucator : echipa.getPlayers())
			{
				punctaj += jucator.score;
			}
			echipa.scor = punctaj;
		}
	else {
			double punctaj = 1;
			for (Player jucator : echipa.getPlayers())
			{
				punctaj *= jucator.score;
			}
			echipa.scor = punctaj;
		}
	}
	
}
