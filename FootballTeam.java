
public class FootballTeam extends Team
{
	public FootballTeam()
	{
		setTeamType("football");
	}
	public int compareTo(Team echipa)
	{
		if (this.scor > echipa.scor)
		{
			return 1;
		} else if (this.scor < echipa.scor)
		{
			return -1;
		}
		return 0;
	}
	public void accept(Visitor v)
	{
        v.calculPunctaj( this );
    }
}
