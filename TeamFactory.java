
/**
 * Clasa folosita pentru a creea tipuri de echipe.
 * Cred ca cel mai dragut design pattern din toata tema prin simplitate
 * si functionalitate.
 */
public class TeamFactory
{
	/**
	 * Returneaza un obiect nou in functie de tipul de care trebuie sa
	 * fie in functie de ce string se primeste.
	 *
	 * @param teamType the team type
	 * @return the team
	 */
	public Team getTeam(String teamType)
	{
		if("football".equals(teamType))
		{
			return new FootballTeam();
		}
		if("basketball".equals(teamType))
		{
			return new BasketballTeam();
		}
		if("handball".equals(teamType))
		{
			return new HandballTeam();
		}
		return null;
	}
	
}
