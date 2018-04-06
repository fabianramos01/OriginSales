package model;

public class Comparator implements java.util.Comparator<Game> {

	@Override
	public int compare(Game o1, Game o2) {
		return o1.getName().equalsIgnoreCase(o2.getName()) && o1.getVersion() == o2.getVersion() ? 0 : 1;
	}
}