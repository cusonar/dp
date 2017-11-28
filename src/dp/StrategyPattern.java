package dp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StrategyPattern {
	
	public static void main(String[] args) {
//		Logging log = new ConsoleLogging();
		Logging log = new FileLogging(new File("./test.txt"));
		log.write("Hello");
	}

}

interface Logging {
	void write(String message);
}

class ConsoleLogging implements Logging {

	@Override
	public void write(final String message) {
		System.out.println(message);
	}
	
}

class FileLogging implements Logging {
	
	private final File toWrite;
	
	public FileLogging(File toWrite) {
		this.toWrite = toWrite;
	}

	@Override
	public void write(final String message) {
		try {
			FileWriter fw = new FileWriter(toWrite);
			fw.write(message);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}