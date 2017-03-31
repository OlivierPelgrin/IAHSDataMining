import java.util.ArrayList;
import java.util.Arrays;

public class ItemSet {
	
	private int[] itemset;
	private CardDatabase cardDb;
	
	public ItemSet(ArrayList<String> cards, CardDatabase cardDb) {
		itemset = new int[cards.size()];
		this.cardDb = cardDb;
		this.buildItemSet(cards);
	}
	
	private void buildItemSet(ArrayList<String> cards) {
		int i = 0;
		for(String s: cards) {
			int tmp = cardDb.getCardId(s);
			itemset[i] = tmp;
			i++;
		}
		Arrays.sort(itemset);
	}
	
	public boolean isEmpty() {
		boolean val = false;
		if(itemset.length == 0) {
			val = true;
		}
		return val;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		for(int i=0; i<itemset.length; i++) {
			str.append(itemset[i] + " ");
		}
		return str.toString();
	}
}
