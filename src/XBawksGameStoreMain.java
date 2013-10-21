import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class XBawksGameStoreMain {

	static final boolean WITH_PLAYERS = true;
	static final boolean WITH_DATE = true;
	static final boolean WITH_RATING = true;

	private static BufferedWriter out;

	/**
	 * @param args Arrrrrrrrrgs!!! that don't do anything and are ignored
	 */
	public static void main(String[] args) {
		/* This implies that we're connecting to a remote server
		 * in an attempt to remove the idea we can interact with
		 * it locally */
		StoreFront storeServer = StoreFront.loginAndConnect();
		
		/* Setup an outgoing file to save our querying results */
		try {
			out = new BufferedWriter(new FileWriter("output.txt"));
		
			/* Ideally, the client would never create these, and would have
			 * limited querying functionality, but I'm pressed for time and
			 * didn't plan out for it.
			 */
			NewestComparator cNC = new NewestComparator();
			HighestRatingComparator cHRC = new HighestRatingComparator();
			Genre[] singleGenre = new Genre[1];
			
			List<XBawksGame> results;
			
			/* 1. Show new releases from a list of all games,
			 *    requiring and not requiring multiplayer
			 */
			out.write("New Releases (with Mulitplayer): \n");
			results = storeServer.searchTopThree(Genre.values(), cNC, WITH_PLAYERS);
			writeResults(results, WITH_DATE, !WITH_RATING, WITH_PLAYERS);
			out.write("New Releases: \n");
			results = storeServer.searchTopThree(Genre.values(), cNC, !WITH_PLAYERS);
			writeResults(results, WITH_DATE, !WITH_RATING, !WITH_PLAYERS);
			
			/* 2. Search all genres individually,
			 *    requiring and not requiring multiplayer
			 */
			out.write("New Releases by Genre (with Multiplayer): \n");
			for (Genre g : Genre.values()) {
				singleGenre[0] = g;
				out.write("\t" + g.toString() + ": \n");
				results = storeServer.searchTopThree(singleGenre, cNC, WITH_PLAYERS);
				writeResults(results, WITH_DATE, !WITH_RATING, WITH_PLAYERS);
			}
			out.write("New Releases by Genre: \n");
			for (Genre g : Genre.values()) {
				singleGenre[0] = g;
				out.write("\t" + g.toString() + ": \n");
				results = storeServer.searchTopThree(singleGenre, cNC, !WITH_PLAYERS);
				writeResults(results, WITH_DATE, !WITH_RATING, !WITH_PLAYERS);
			}
	
			/* 3. Show highest rated releases from a list of all games,
			 *    requiring and not requiring multiplayer
			 */
			out.write("Highest Rated Games (with Multiplayer): \n");
			results = storeServer.searchTopThree(Genre.values(), cHRC, WITH_PLAYERS);
			writeResults(results, !WITH_DATE, WITH_RATING, WITH_PLAYERS);
			out.write("Highest Rated Games: \n");
			results = storeServer.searchTopThree(Genre.values(), cHRC, !WITH_PLAYERS);
			writeResults(results, !WITH_DATE, WITH_RATING, !WITH_PLAYERS);
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println();
			System.err.println("I can haz write access to ./output.txt, please?");
			System.err.println("I promise I'll behave! >:)");
		}
	}

	/**
	 * Holy long method signature codemonkey! This method takes in a list of games and
	 * constraints to make printing results to file easier and less hard coding... than
	 * it already is...
	 * 
	 * @param results     list of games to print
	 * @param withDate    print date before game name
	 * @param withRating  print rating before game name after date
	 * @param withPlayers print number of players at the end of game name
	 *                    after all, anything to help market your revenue stream!
	 * @throws IOException if something goes wrong, let the parent catch it since it's
	 *                     already in a try-catch anyway
	 */
	private static void writeResults(List<XBawksGame> results,
			boolean withDate, boolean withRating, boolean withPlayers) throws IOException {
		int i = 0;
		for (XBawksGame g : results) {
			out.write("\t\t" + ++i + ") ");
			
			if (withDate)
				out.write(g.getReleaseDate() + " ");
			
			if (withRating)
				out.write(g.getRating() + " ");
			
			out.write(g.getName() + " ");
			
			if (withPlayers)
				out.write(g.getNumPlayers());
			
			out.write("\n");
		}
	}

}
