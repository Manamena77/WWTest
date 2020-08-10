package firstQuestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryReader {
	static File dir;
	static File tempFile;
	static String fileName;
	static String path;

	public static void main(String[] args) {
		try {

			System.out.println(doesFileExist("Dictionary.txt", "src/test/resources"));
			fileReader("src/test/resources", "Dictionary.txt");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String doesFileExist(String fileName, String path) throws FileNotFoundException {

		dir = new File(path);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {

				return ("Dear user please note that your file name: ***" + fileName + "*** exists in the given path: "
						+ path);
			}
		}
		return ("Dear user please note that your file name: ***" + fileName + "*** does't exist in the given path: "
				+ path);

	}

	public static List<String> fileReader(String path, String fileName) throws FileNotFoundException {

		List<String> meaningList = new ArrayList<String>();
		tempFile = new File(path + "/" + fileName);
		Scanner scanner = new Scanner(tempFile);
		while (scanner.hasNextLine()) {

			meaningList.add(scanner.nextLine());

		}

		scanner.close();
		for (int i = 0; i < meaningList.size(); i++) {
			String whole = meaningList.get(i);
			String[] words = generateStrarray(whole);
			String word = words[0];
			String meaning = words[1];
			String[] meanings = generatemeaningarray(meaning);
			System.out.println(word);
			if (meaning.contains(",")) {
				System.out.println(meanings[0]);
				System.out.println(meanings[1]);
			} else {
				System.out.println(meaning);
			}

		}

		return meaningList;
	}

	public static String[] generateStrarray(String wordsmeanings) {
		String whole = wordsmeanings.replaceFirst("\\s", "");
		String[] words = whole.split("–");
		return words;
	}

	public static String[] generatemeaningarray(String meanings) {
		String[] meaning = null;

		meaning = meanings.split(",");
		return meaning;

	}
}
