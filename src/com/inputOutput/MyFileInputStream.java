package com.inputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class MyFileInputStream {
	
	public static void readBytesFromFile(String filename) {
		InputStream in = null;
		try {
			 in = new FileInputStream(filename);
			 int b = -1;
			 while((b = in.read()) != -1) {
				 char c = (char)b;
				 System.out.print(c);
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void readByteArrayFromFile(String filename) {
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			byte [] buffer = new byte[10];
			while(in.read(buffer) > 0) {
				for(int i = 0; i < buffer.length; i++) {
					System.out.print((char)buffer[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
	}
	
	public static void tryWithResourceExample(String inputFile, String outputFile) {
		
		/**
		 * Reader/Writer and InputStream/OutputStream implements closable interface which in turn
		 * uses Autoclosable interface. Closable is legacy interface and can only throw IO Exceptions
		 * whereas Autoclosable can throw any kind of exceptions.
		 */
		
		try(FileReader fr = new FileReader(inputFile); FileWriter fw = new FileWriter(outputFile);) {
			char buffer [] = new char[10];
			while(fr.read(buffer) > 0) {
				fw.write(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		//readBytesFromFile("Resources" + File.separator+ "abc.txt");
		//readByteArrayFromFile("Resources" + File.separator+ "abc.txt");
		tryWithResourceExample("Resources" + File.separator + "abc.txt", "Resources" + File.separator + "xyz.txt");
		
	}
}
