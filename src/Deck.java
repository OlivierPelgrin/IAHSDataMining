import java.util.ArrayList;

public class Deck {
	
	private static int idcompter = 1; // to get an id for each deck
	
	private CardDatabase cardDb;
	
	private ArrayList<String> theDeck;
	private int id;
	
	public Deck(CardDatabase cardDb) {
		this.cardDb = cardDb;
		id = idcompter;
		idcompter++;
		theDeck = new ArrayList<String>();
	}
	
	private Deck(CardDatabase cardDb, int id) {
		this.cardDb = cardDb;
		this.id = id;
		theDeck = new ArrayList<String>();
	}
	
	public void addCard(String card) {
		if(!cardDb.isHeroPower(card)) {
			cardDb.addCard(card);
			if(!theDeck.contains(card)) {
				theDeck.add(card);
			}			
		}
	}
	
	
	public int getID() {
		return id;
	}
	
	public String toString(){
		StringBuffer str = new StringBuffer();
		for(String c: theDeck) {
			str.append(c);
			str.append("\n");
		}
		return str.toString();
	}
	
	public Deck copy(){
		Deck d = new Deck(this.cardDb, this.id);
		for(String s: theDeck) {
			d.addCard(s);
		}
		return d;
	}
	
	
	public ItemSet toItemSet() {
		/*int[] itemset = new int[theDeck.size()];
		int i = 0;
		for(String s: theDeck) {
			int tmp = cardDb.getCardId(s);
			itemset[i] = tmp;
			i++;
		}
		Arrays.sort(itemset);
		return itemset;*/
		return new ItemSet(theDeck, cardDb);
	}
	
}
