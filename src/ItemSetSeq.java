import java.util.ArrayList;

public class ItemSetSeq {
	
	private ArrayList<ItemSet> sequence;
	
	public ItemSetSeq() {
		sequence = new ArrayList<ItemSet>();
	}
	
	private ItemSetSeq(ArrayList<ItemSet> set) {
		ArrayList<ItemSet> seq = new ArrayList<ItemSet>(set);
		sequence = seq;
	}
	
	public void add(ItemSet s) {
		sequence.add(s);
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		for(ItemSet is: sequence) {
			if(!is.isEmpty()) {
				str.append(is.toString() + "-1 ");
			}
		}
		str.append("-2");
		return str.toString();
	}
	
	public ItemSetSeq copy(){
		return new ItemSetSeq(this.sequence);
	}

}
