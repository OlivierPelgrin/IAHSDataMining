import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		CardDatabase cardDb = new CardDatabase();
		
		DeckExtractor de = new DeckExtractor("all_absolute-.txt", cardDb);
		ArrayList<Deck> decks = de.getDecks();
		System.out.println("Decks load from file");
		
		ArrayList<int[]> itemSets = new ArrayList<int[]>(); 
		
		for(Deck d: decks) {
			itemSets.add(d.toItemSet());
		}
		
		FileUtils.writeItemSets(itemSets);
		
		AlgorithmExecutor.executeFpClose(10);
		
		String result = FileUtils.readOutputFile();
		
		System.out.println(cardDb.formatOutput(result));
	}

}
