import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class GameDatabaseReader {

	private Scanner sc;
	private int numGames;
	private List<XBawksGame> listGames;
	
	public GameDatabaseReader(String databaseFile) {
		try {
			sc = new Scanner(new File(databaseFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		numGames = sc.nextInt();
	}
	
	/**
	 * Convenience method for reading in the entirety
	 * of the game database
	 * @return a list of XBawksGames
	 */
	public List<XBawksGame> readGames() {		
		for (int i = 0; i < numGames; ++i) {
			try {
				XBawksGame game = readGame();
				listGames.add(game);
			} catch(ParseException e) {
				e.printStackTrace();
			}
		}
		
		return listGames;
	}
	
	/**
	 * Convenience method for reading in a game object
	 * @return a filled XBawksGame object
	 * @throws ParseException when can't parse a date
	 */
	public XBawksGame readGame() throws ParseException {
		DateFormat df = DateFormat.getDateInstance();
		
		String name = sc.next();
		Date releaseDate = df.parse(sc.next());
		
		// Parse slash '/' delimited genres here.
		List<Genre> genres = new ArrayList<Genre>();
		String[] tokens = sc.nextLine().split("/");
		for (String t : tokens) {
			genres.add(Genre.valueOf(t.trim()));
		}
		
		float rating = sc.nextFloat();
		
		int numPlayers = sc.nextInt();
		
		boolean isMultiplayer = numPlayers > 1;
		
		XBawksGame game = new XBawksGame(name, releaseDate, genres, rating, numPlayers, isMultiplayer);
		return game;
	}

	public void close() {
		sc.close();
	}
}
