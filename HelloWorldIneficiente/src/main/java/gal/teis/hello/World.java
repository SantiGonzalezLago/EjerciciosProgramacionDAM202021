package gal.teis.hello;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class World {
	public static void main(String[] args) throws IOException {
		File pythonFile = new File(System.getProperty("user.home"), "hello123456.py");
		pythonFile.createNewFile();
		pythonFile.deleteOnExit();
		
		FileWriter fw = new FileWriter(pythonFile);
		fw.write("print(\"Hello World\")");
		fw.close();
		
		Process p = new ProcessBuilder("python", pythonFile.getAbsolutePath()).start();

		try {
			InputStream is = p.getInputStream();

			 int c;
			 while ((c = is.read()) != -1)
				System.out.print((char) c);
			 is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
