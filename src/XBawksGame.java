import java.util.Date;

/**
 * @author Bret Wood
 *
 */
public class XBawksGame {
	private String name;
	private Date releaseDate;
	private Genre genre;
	private float rating;
	private int numPlayers;
	private boolean isMultiplayer;
	
	public XBawksGame(String name, Date releaseDate, Genre genre, float rating, int numPlayers, boolean isMultiplayer) {
		this.name = name;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.rating = rating;
		this.numPlayers = numPlayers;
		this.isMultiplayer = isMultiplayer;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public float getRating() {
		return rating;
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}
	
	public boolean getIsMultiplayer() {
		return isMultiplayer;
	}
	
}
