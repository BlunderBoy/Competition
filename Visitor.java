
/**
 * Interfata Visitor ce defineste functiile ce trebuie implementate.
 */
public interface Visitor
{
	/**
	 * Calcul punctaj pentru o echipa de basket.
	 *
	 * @param echipa the echipa
	 */
	void calculPunctaj(BasketballTeam echipa);
	
	/**
	 * Calcul punctaj pentru o echipa de fotbal.
	 *
	 * @param echipa the echipa
	 */
	void calculPunctaj(FootballTeam echipa);
	
	/**
	 * Calcul punctaj pentru o echipa de handball.
	 *
	 * @param echipa the echipa
	 */
	void calculPunctaj(HandballTeam echipa);
}
