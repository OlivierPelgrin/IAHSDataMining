import java.io.IOException;
import java.util.ArrayList;

public class RoundExtractor {
	
	private String datafile; // name of the data file
	
	private CardDatabase cardDb;
	
	public RoundExtractor(String file, CardDatabase cardDb) {
		this.cardDb = cardDb;
		this.datafile = file;
	}
	
	public ArrayList<ItemSetSeq> getSequences() throws IOException{
		ArrayList<ItemSetSeq> temp = new ArrayList<ItemSetSeq>();
		
		String[] fileContent = FileUtils.asStringArray(datafile);
		
		int currentGameNum = 0;
		int currentRoundNum = 0;
		
		ItemSetSeq seqM = new ItemSetSeq();
		ItemSetSeq seqO = new ItemSetSeq();
		
		ArrayList<String> cardM = new ArrayList<>();
		ArrayList<String> cardO = new ArrayList<>();
		
		for(String s: fileContent) {
			
			String[] tmp = s.split(" ");
			
			int gameNum = Integer.parseInt(tmp[0]);			
					
			if(gameNum != currentGameNum) {
				currentGameNum = gameNum;
				temp.add(seqO.copy());
				temp.add(seqM.copy());
				seqM = new ItemSetSeq();
				seqO = new ItemSetSeq();				
			}
			
			int roundNum = Integer.parseInt(tmp[2]);
			
			if(roundNum != currentRoundNum) {
				currentRoundNum = roundNum;
				seqM.add(new ItemSet(cardM, cardDb));
				cardM = new ArrayList<>();
				seqO.add(new ItemSet(cardO, cardDb));
				cardO = new ArrayList<>();
			}
			
			if(tmp[1].compareTo("Begin") != 0) {	
				char player = tmp[1].charAt(0);
				String cardName = tmp[1].substring(1);
				if(player == 'O'){
					if(!cardDb.isHeroPower(cardName)) {
						cardO.add(cardName);
						cardDb.addCard(cardName);
					}
				} else {
					if(!cardDb.isHeroPower(cardName)) {
						cardM.add(cardName);
						cardDb.addCard(cardName);
					}
				}
			}
		}		
		return temp;
	}

}
