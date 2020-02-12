
public class HandballTeam extends Team
{
	HandballTeam()
	{
		setTeamType("handball");
	}
	int compareTo(Team echipa)
	{
		return super.compareTo(echipa);
	}
	public void accept(Visitor v)
	{
        v.calculPunctaj( this );
    }
}
