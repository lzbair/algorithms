package io.devideandconquer;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InversionDetector {

	public static void main(String[] args) {

		Path path = Paths.get("ressources", "IntegerArray.txt");
		List<String> lines = null;
		try {
			lines = Files.readAllLines(path, Charset.defaultCharset());
		} catch (IOException e) {
			//
		}
		BigInteger is = BigInteger.ZERO;
		for (int i = 0; i < lines.size(); i++) {
			int base = Integer.parseInt(lines.get(i));
			for (int j = i + 1; j < lines.size(); j++) {
				int next = Integer.parseInt(lines.get(j));
				if (base > next) {
					is = is.add(BigInteger.ONE);
				}
			}
		}
		System.out.println(is);
	}

}
