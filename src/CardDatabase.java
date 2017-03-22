import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CardDatabase {
	
	private int idcompter;
	
	private HashMap<String, Integer> database;
	
	private ArrayList<String> heroPowers;

	private void initHeroPowers(){
		heroPowers = new ArrayList<String>();
		String[] hp = {"Shapeshift", "SteadyShot", "Fireblast", "Reinforce", "LesserHeal", "DaggerMastery", "TotemicCall", "LifeTap", "ArmorUp!"};
		for(String s: hp) {
			heroPowers.add(s);
		}
	}
	
	public CardDatabase() {
		idcompter = 1;
		this.database = new HashMap<String, Integer>();
		initHeroPowers();
	}
	
	public void addCard(String card) {
		if(!database.containsKey(card) && !heroPowers.contains(card)) {
			database.put(card, idcompter);
			idcompter++;
		}
	}
	
	public int getCardId(String card) {
		int returnValue = -1;
		if(database.containsKey(card)) {
			returnValue = database.get(card);
		} else {
			System.err.println("The card " + card + " does not exist !");
		}
		return returnValue;
	}
	
	public String getCardById(int id) {
		String returnVal = "";
		if(database.containsValue(id)) {
			Set<String> keySet = database.keySet();
			Iterator<String> it = keySet.iterator();
			boolean finded = false;
			while(it.hasNext() && !finded) {
				String tmp =  it.next();
				int tmpid = database.get(tmp);
				if(tmpid == id) {
					finded = true;
					returnVal = tmp;
				}
			}
		}
		return returnVal;
	}
	
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		ArrayList<String> keyList = new ArrayList<String>(database.keySet());
		keyList.sort(String.CASE_INSENSITIVE_ORDER);
		Iterator<String> it =  keyList.iterator();
		while(it.hasNext()) {
			String cardname = it.next();
			int id = database.get(cardname);
			buffer.append("Name : " + cardname + " | ID : " + id + "\n");
		}
		return buffer.toString();
	}
	
	
	public boolean isHeroPower(String cardName) {
		return heroPowers.contains(cardName);
	}
	

	public String formatOutput(String out) {
		StringBuffer buffer = new StringBuffer();
		String[] lines = out.split("\n");
		for(String s1: lines) {
			String[] line = s1.split("#SUP:");
			String[] items = line[0].split(" ");
			int support = Integer.parseInt(line[1].substring(1));
			for(String s2: items) {
				int tmpId = Integer.parseInt(s2);
				String cardName = this.getCardById(tmpId);
				buffer.append(cardName + " ");
			}
			buffer.append(" || SUPPORT : " + support + "\n");
		}
		return buffer.toString();
	}

}
