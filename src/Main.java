import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		CardDatabase cardDb = new CardDatabase();
		
		/*DeckExtractor de = new DeckExtractor("all_absolute+.txt", cardDb);
		ArrayList<Deck> decks = de.getDecks();
		System.out.println("Decks load from file");
		
		ArrayList<ItemSet> itemSets = new ArrayList<ItemSet>(); 
		
		for(Deck d: decks) {
			itemSets.add(d.toItemSet());
		}
		
		FileUtils.writeItemSets(itemSets);
		
		AlgorithmExecutor.executeFpClose(8); */
		
		RoundExtractor re = new RoundExtractor("all_absolute+.txt", cardDb);
		ArrayList<ItemSetSeq> sequences = re.getSequences();
		System.out.println("Sequences load from file");
		
		FileUtils.writeSequences(sequences);
		
		AlgorithmExecutor.executeCloSpan(4);
		
		String result = FileUtils.readOutputFile();
		
		//System.out.println(result);
		
		System.out.println(cardDb.formatOutput(result, 2));
		
	}

}
