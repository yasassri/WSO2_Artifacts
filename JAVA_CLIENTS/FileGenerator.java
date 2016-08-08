import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileGenerator {

	private static final int ITERATIONS = 100000;
	
	private static final int RECORD_COUNT = 8;
	
	String targetFilePath = "/home/yasassri/Desktop/vfs-test/in/file10.txt";

	public static void main(String[] args) throws Exception {
		Writer writer = null;
		String constRecord =
		                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String Record =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

		
		try {

			for (int i = 0; i <= RECORD_COUNT; i++) {
				String tmpRecord = Record.concat(constRecord);
				Record = tmpRecord;
			}

			File file = new File(targetFilePath);
			writer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i <= ITERATIONS; i++) {
				writer.write(Record+"\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("finished***");
	}
}
