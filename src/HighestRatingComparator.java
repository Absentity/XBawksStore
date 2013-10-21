import java.util.Comparator;


public class HighestRatingComparator implements Comparator<XBawksGame> {

	@Override
	public int compare(XBawksGame g1, XBawksGame g2) {
		return Float.compare(g2.getRating(), g1.getRating());
	}
}
