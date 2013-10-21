import java.util.ArrayList;
import java.util.List;


public class StoreFront {
	private List<XBawksGame> gamesList;
	
	public StoreFront() {
		gamesList = new ArrayList<XBawksGame>();
		
		// Read in our database
		GameDatabaseReader games = new GameDatabaseReader("input.txt");
	}
	
	/**
	 * Provides implied client-server architecture 
	 * @return connection to store front activities
	 */
	public static StoreFront connect() {
		return new StoreFront();
	}
}
