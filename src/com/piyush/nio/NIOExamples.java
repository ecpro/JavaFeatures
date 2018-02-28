package com.piyush.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * java.io.FileXX has been depricated 
 * instead java.nio.File is used
 * @author RaviPiyu
 *
 */
public class NIOExamples {
	
	public static void readFile(String filename) {
		// Paths provides static factory method to return Path
		// Path can represent any file system item - can be a directory or a file
		Path path = Paths.get(filename);
		
		try(BufferedReader br = Files.newBufferedReader(path)) {
			String s = null;
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void copyFileContent(String from, String to) {
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(from)); BufferedReader br = Files.newBufferedReader(Paths.get(to));) {
			Path copy = Files.copy(Paths.get(from), Paths.get(to));
			System.out.println(copy);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		String from = "Resources" + File.separator + "abc.txt";
		String to = "Resources" + File.separator + "xyz.txt"; 
		readFile(from);
		copyFileContent(from, to);
		
		for (String string : Files.readAllLines(Paths.get(from))) {
			System.out.println(string);
		}
	}
}
