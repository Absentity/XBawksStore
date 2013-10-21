import java.util.Iterator;
import java.util.List;


public class ListFilters {

	/**
	 * Search all genres of each game and check them against a criteria
	 * list of genres. Removes games that do not contain a genre in the
	 * provided criteria list
	 * @param list   games to search through
	 * @param genres genres to match games against
	 */
	public static void byGenre(List<XBawksGame> list, Genre[] genres) {
		Iterator<XBawksGame> it = list.iterator();
		while (it.hasNext()) {
			Boolean remove = true;
			XBawksGame g = it.next();
			
			// Search all genres the game contains
			for (Genre gameGenre : g.getGenres()) {
				for (Genre criteriaGenre : genres) {
					if (gameGenre == criteriaGenre) {
						remove = false;
						break;
					}
				}
				if (!remove)
					break;
			}
			
			if (remove)
				it.remove();
		}
	}

	/**
	 * Remove games that don't have the multiplayer flag
	 * @param list of games that are exclusively multiplayer
	 */
	public static void byMultiplayer(List<XBawksGame> list) {
		Iterator<XBawksGame> it = list.iterator();
		while (it.hasNext()) {
			XBawksGame g = it.next();
			if (!g.isMultiplayer()) {
				it.remove();
			}
		}
	}
}
