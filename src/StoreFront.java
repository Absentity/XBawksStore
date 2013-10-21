import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class manages the display and ordering the sorting of game lists
 * @author Bret
 *
 */
public class StoreFront {
	private List<XBawksGame> gamesList;
	
	public StoreFront() {
		gamesList = new ArrayList<XBawksGame>();
		
		// Read in our database
		GameDatabaseReader games = new GameDatabaseReader("input.txt");
		gamesList = games.readGames();
		games.close();
	}
	
	public List<XBawksGame> searchTopThree(Genre[] genres, Comparator<XBawksGame> sorter, boolean forMultiplayer) {
		List<XBawksGame> searchList = new ArrayList<XBawksGame>(gamesList);
		Collections.sort(searchList, sorter);
		ListFilters.byGenre(searchList, genres);
		if (forMultiplayer)
			ListFilters.byMultiplayer(searchList);
		
		return searchList.subList(0, (searchList.size() >= 3) ? 3 : searchList.size());
	}
	
	/**
	 * Helps simulate a client-server connection
	 * @return connection to store front activities
	 */
	public static StoreFront loginAndConnect() {
		return new StoreFront();
	}

}
