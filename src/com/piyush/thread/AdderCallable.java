package com.piyush.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AdderCallable implements Callable<Integer> {

	private String inFile, outFile;

	public AdderCallable(String inFile, String outFile) {
		this.inFile = inFile;
		this.outFile = outFile;
	}

	public int doAdd() {
		int total = 0;
		try (BufferedReader br = Files.newBufferedReader(Paths.get(inFile))) {
			for (;;) {
				String s = br.readLine();
				if (s == null)
					break;
				total += Integer.parseInt(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(outFile), StandardOpenOption.CREATE,
				StandardOpenOption.TRUNCATE_EXISTING)) {
			bw.write(String.valueOf(total));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Data written to file : " + outFile);
		return total;
	}

	public static void main(String[] args) {
		// String from = "Resources"+File.separator+"x" + 0 + ".txt";
		// String to = "Resources"+File.separator+"y" + 0 + ".txt";
		ExecutorService exec = Executors.newFixedThreadPool(3);
		List<Future<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			AdderCallable adder = new AdderCallable("Resources" + File.separator + "x" + i + ".txt",
					"Resources" + File.separator + "y" + i + ".txt");
			Future<Integer> result = exec.submit(adder);
			list.add(result);
		}

		exec.shutdown();
		try {
			exec.awaitTermination(60, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(Future<Integer> result : list) {
			try {
				System.out.print("result "+ result.get() + "\n");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		// createFiles();
		System.out.print("batch processing completed");

	}

	@SuppressWarnings("unused")
	private static void createFiles() {
		for (int i = 0; i < 5; i++) {
			String filePath = "Resources" + File.separator + "x" + i + ".txt";
			Random random = new Random();
			int start = random.nextInt(20);
			try (BufferedWriter br = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING)) {
				for (int j = 0; j < 5; j++) {
					br.write(String.valueOf(start));
					br.newLine();
					start++;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Integer call() throws Exception {
		return this.doAdd();
	}

}
