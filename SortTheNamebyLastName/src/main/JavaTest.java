package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Logger;

public class JavaTest {

	private static Logger logger = Logger.getLogger(JavaTest.class.getName());

	/**
	 * This method is used to read the data from the File
	 * 
	 * @param filePath Path of the file which needs to be Read
	 * @return List of File Data
	 * @throws Exception Generic Exception
	 */
	private static ArrayList<String> readFile(String filePath) throws Exception {
		ArrayList<String> list = new ArrayList<>();
		try {
			Scanner s = new Scanner(new File(filePath));
			while (s.hasNext()) {
				list.add(s.nextLine());
			}
			s.close();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		logger.info("Content in the File :: " + list.toString());
		return list;
	}

	/**
	 * This method is used to sort the file content
	 * 
	 * @param fileData Data in the file
	 * @return sortedList of data
	 */
	private static ArrayList<String> sortFileContent(ArrayList<String> fileData) {
		Collections.sort(fileData, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String[] split1 = o1.split(" ");
				String[] split2 = o2.split(" ");
				String lastName1 = split1[1];
				String lastName2 = split2[1];
				if (lastName1.compareTo(lastName2) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		return fileData;
	}

	/**
	 * This method is used to write the sortedResponse to the File
	 * 
	 * @param sortedRes sortedList of data
	 */
	private static void writeFile(ArrayList<String> sortedRes) {
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("sorted-names-list.txt");
			for (String str : sortedRes) {
				myWriter.write(str + System.lineSeparator());
			}
			myWriter.close();
			logger.info("Data written to the file successfuly.");
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			if (args.length > 0) {
				ArrayList<String> res = readFile(args[0]);
				if (!res.isEmpty()) {
					ArrayList<String> sortedRes = sortFileContent(res);
					logger.info("Sorted Response ::" + sortedRes);
					writeFile(sortedRes);
				} else {
					logger.info("Error while sorting the File Data");
				}
			} else {
				logger.info("No valid file path provided as argument");
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
}
