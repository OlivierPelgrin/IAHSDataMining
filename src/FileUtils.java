import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileUtils {

	
	public static String[] asStringArray(String filename) throws IOException {
		String[] str;
		Path path = FileSystems.getDefault().getPath("Ressources"+File.separator+"data", filename);
		str = Files.lines(path).toArray(String[]::new);
		return str;
	}
	
	public static void writeItemSets(ArrayList<ItemSet> itemSets) throws IOException {
		StringBuffer str = new StringBuffer();
		for(int i=0; i<itemSets.size(); i++) {
			ItemSet tmp = itemSets.get(i);
			str.append(tmp.toString());
			str.append("\n");
		}
		Path path = FileSystems.getDefault().getPath("input.txt");
		if(Files.exists(path)){
			Files.delete(path);
		}
		OutputStream os = Files.newOutputStream(path);
		os.write(str.toString().getBytes());
		os.close();
	}
	
	public static void writeSequences(ArrayList<ItemSetSeq> sequences) throws IOException {
		StringBuffer str = new StringBuffer();
		for(ItemSetSeq iss: sequences) {
			str.append(iss.toString() + "\n");
		}
		Path path = FileSystems.getDefault().getPath("input.txt");
		if(Files.exists(path)){
			Files.delete(path);
		}
		OutputStream os = Files.newOutputStream(path);
		os.write(str.toString().getBytes());
		os.close();
	}
	
	public static String readOutputFile() throws IOException {
		Path path = FileSystems.getDefault().getPath("output.txt");
		String[] str;
		StringBuffer buffer = new StringBuffer();
		str = Files.lines(path).toArray(String[]::new);
		for(String s: str) {
			buffer.append(s + "\n");
		}
		return buffer.toString();
	}
	
}
