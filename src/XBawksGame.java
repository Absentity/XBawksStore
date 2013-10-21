import java.util.Date;
import java.util.List;

/**
 * @author Bret Wood
 *
 */
public class XBawksGame {
	private String name;
	private Date releaseDate;
	private List<Genre> genres;
	private float rating;
	private int numPlayers;
	private boolean isMultiplayer;
	
	public XBawksGame(String name, Date releaseDate, List<Genre> genres, float rating, int numPlayers, boolean isMultiplayer) {
		this.name = name;
		this.releaseDate = releaseDate;
		this.genres = genres;
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
	
	public List<Genre> getGenres() {
		return genres;
	}
	
	public float getRating() {
		return rating;
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}
	
	public boolean isMultiplayer() {
		return isMultiplayer;
	}
	
}
