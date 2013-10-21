import java.util.Comparator;


public class NewestComparator implements Comparator<XBawksGame> {

	@Override
	public int compare(XBawksGame g1, XBawksGame g2) {
		return g2.getReleaseDate().compareTo(g1.getReleaseDate());
	}

}
