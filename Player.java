
/**
 * Reprezentarea simpla a unui jucator.
 * Am suprascris toString pentru a afisa mai usor la cerinta 1 echipele.
 */
public class Player
{
	String name;
	double score;
	
	/**
	 * Instantiates a new Player.
	 *
	 * @param name  the name
	 * @param score the score
	 */
	public Player(String name, String score)
	{
		this.name = name;
		this.score = Integer.parseInt(score);
	}
	
	@Override
	public String toString()
	{
		return "{" +
				"name: " + name + ", " +
				"score: " + (int)score +
				'}';
	}
}
