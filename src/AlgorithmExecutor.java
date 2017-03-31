import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class AlgorithmExecutor {

	public static void executeFpClose(int supmin) throws IOException {
		
		Path out = FileSystems.getDefault().getPath("output.txt");
		Path in = FileSystems.getDefault().getPath("input.txt");
		
		String cmd = "java -jar Ressources"+ File.separator +"spmf.jar run FPClose "+in.toString()+" "+out.toString()+" "+supmin+"%";

		if(Files.exists(out)) {
			Files.delete(out);
		}
		
		Runtime runtime = Runtime.getRuntime();
		Process p = runtime.exec(cmd);
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void executeCloSpan(int supmin) throws IOException {
		
		Path out = FileSystems.getDefault().getPath("output.txt");
		Path in = FileSystems.getDefault().getPath("input.txt");
		
		String cmd = "java -jar Ressources"+ File.separator +"spmf.jar run CloSpan "+in.toString()+" "+out.toString()+" "+supmin+"%";

		if(Files.exists(out)) {
			Files.delete(out);
		}
		
		Runtime runtime = Runtime.getRuntime();
		Process p = runtime.exec(cmd);
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
