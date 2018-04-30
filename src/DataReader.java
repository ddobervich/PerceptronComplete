import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DataReader {

	private static String normalizeLineBreaks(String s) {
		return s.replace("\r\n", "\n").replace('\r', '\n');
	}

	public static String readFileAsString(String filepath) {
		try {
			ClassLoader classLoader = DataReader.class.getClassLoader();
			File file = new File(classLoader.getResource(filepath).getFile());

			// Read File Content
			String content = "";
			try {
				content = new String(Files.readAllBytes(file.toPath()));
			} catch (IOException e) {
				System.err.println("FILE NOT FOUND: " + filepath);
				e.printStackTrace();
			}

			return content;

		} catch (Exception e) {
			System.out.println("Error reading data file");
			System.out.println("Note:  Add the data folder to your project classpath");
		}

		return null;
	}

	public static DataSet createDataSet(String filepath, int linesToSkip, String[] columnHeaders) {
		String data = normalizeLineBreaks(readFileAsString(filepath));
		String[] lines = data.split("\n");

		int numColumns = columnHeaders.length - 1; // last column is not a numeric column

		int startRow = linesToSkip;

		// create storage for data
		DataSet dataset = new DataSet();

		for (int r = startRow; r < lines.length; r++) {
			String line = lines[r];
			String[] coords = line.split(",");

			float[] datavals = new float[numColumns];
			for (int j = 0; j < numColumns; j++) {
				float val = 0;
				try {
					val = Float.parseFloat(coords[j]);
				} catch (Exception e) {
					System.err.println("Warning: invalid number format");
				}
				datavals[j] = val;
			}

			String label = coords[numColumns]; // column after numbers is label
			dataset.add(new DataPoint(datavals, label));
		}

		return dataset;
	}
}