package info.tonyl.pokeapi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelGenerator {
	public static final String INPUT_FILENAME = "modelInput.txt";

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		System.out.println("Model name?");
		String name = s.nextLine();
		s.close();

		BufferedReader input = new BufferedReader(new FileReader(loadOrMake(INPUT_FILENAME)));
		BufferedWriter output = new BufferedWriter(new FileWriter(new File(name + ".java")));

		output.write("package info.tonyl.pokeapi.models;\n\n");
		output.write("import com.google.gson.annotations.SerializedName;\n\n");
		output.write("import info.tonyl.pokeapi.annotations.ResourceClass;\n");
		output.write("import lombok.AccessLevel;\n");
		output.write("import lombok.Data;\n");
		output.write("import lombok.Setter;\n");
		output.write("\n@Data\n@Setter(AccessLevel.NONE)\npublic class ");
		output.write(name);
		output.write(" {\n");

		String line;
		while ((line = input.readLine()) != null) {
			System.out.println("Input line:");
			System.out.println(line);

			StringBuilder outline = new StringBuilder();
			String[] tokens = line.split("\t");

			outline.append("\t@SerializedName(\"" + tokens[0] + "\")\n");
			outline.append(resourceClassAnnotation(tokens[2]));
			outline.append("\tprivate ");
			outline.append(getTypeName(tokens[2]));
			outline.append(" ");
			outline.append(camelCase(tokens[0]));
			outline.append(";\n\n");

			System.out.println("Output block:");
			System.out.println(outline);

			output.write(outline.toString());
		}

		output.write("}");

		input.close();
		output.flush();
		output.close();
	}

	private static String camelCase(String str) {
		String[] words = str.split("_");
		if (words.length > 1) {
			String result = words[0];
			for (int i = 1; i < words.length; i++) {
				result += capitalize(words[i]);
			}
			return result;
		} else {
			return str;
		}
	}

	private static String capitalize(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	private static String resourceClassAnnotation(String str) {
		Pattern resourcePattern = Pattern.compile("\\((.*)\\)");
		Matcher m = resourcePattern.matcher(str);

		String result = "";

		if (m.find()) {
			result = "\t@ResourceClass(" + m.group(1) + ".class)\n";
		}

		return result;
	}

	private static String getTypeName(String str) {
		final String LIST_PREFIX = "list ";
		final String RESOURCE_PREFIX = "NamedAPIResource (";

		Pattern resourcePattern = Pattern.compile("\\((.*)\\)");

		String result = "";

		if (str.startsWith(LIST_PREFIX)) {
			str = str.substring(LIST_PREFIX.length());
			result += getTypeName(str);
			result += "[]";
		} else if (str.startsWith(RESOURCE_PREFIX)) {
			Matcher m = resourcePattern.matcher(str);
			m.find();
			result += "ApiResource<";
			result += m.group(1);
			result += ">";
		} else {
			switch (str) {
			case "integer":
			case "boolean":
			case "string":
				result = capitalize(str);
				break;
			default:
				result = str;
				break;
			}
		}

		return result;
	}

	private static File loadOrMake(String path) throws IOException {
		File f = new File(path);
		if (f.exists()) {
			return f;
		} else {
			f.createNewFile();
			return f;
		}
	}
}
