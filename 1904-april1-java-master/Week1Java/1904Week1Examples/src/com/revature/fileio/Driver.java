package com.revature.fileio;

import java.io.*;

public class Driver {
//	Note that when making constants (final fields)
//	convention suggests using upper snake casing
	private final String FILE_NAME = "files/myfile.csv";
	private FileOutputStream fos = null;
	private FileInputStream fis = null;
	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	private BufferedWriter bw = null;

	public static void main(String[] args) {
		System.out.println("====START====");
		Driver driver = new Driver();
		try {
			driver.fosExample();
			driver.fisExample();
			driver.fileWriterAndReaderExample();
			driver.bufferedExample();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("=====END====");
	}

	public void fosExample() throws IOException {
		/*
		 * FileInput/OutputStreams -these streams are able to write/read data ONE BYTE
		 * at a time.
		 */
		try {
			fos = new FileOutputStream(FILE_NAME);
			char rand;

			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					rand = (char) (Math.random() * 26 + 'A');
//		The code above selects a random letter (uppercase)
//		that is anywhere from A to Z
					fos.write((byte) rand);
					if (j < 14) {
						fos.write(',');
					}
				}
				fos.write('\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				fos.close();
			}
		}

		/*
		 * Though java is good at it, it is not perfect at automatically closing your
		 * streams. It is good practice to close your io streams just in case of memory
		 * leaks.
		 */
	}

	public void fisExample() throws IOException {
		try {
			fis = new FileInputStream(FILE_NAME);
			byte in;
			// when reading in bytes, if you ever get -1
			// this means that you reached the end of the file
			while ((in = (byte) fis.read()) != -1) {
				System.out.print((char) in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}

	public void fileWriterAndReaderExample() throws IOException {
		/*
		 * File Reader/Writer -the underlying difference between a file reader and a
		 * file input stream is that the reader and writer cater to the streams ONE
		 * CHARACTER at a time as opposed to ONE BYTE at a time.
		 */

		try {
			fr = new FileReader(FILE_NAME);
			fw = new FileWriter(FILE_NAME.split("\\.")[0] + "_lowerCase." + FILE_NAME.split("\\.")[1]);
			// this writes to a file called "myfile_lowerCase.csv
			int in;
			while ((in = fr.read()) != -1) {
				if (in == 10 || in == 44) {// 44 is ',' 10 is '\n'
					fw.write((char) in);
				} else {
					fw.write((char) (in + 32)); // give you lower case value
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				fr.close();
			}
			if (fw != null) {
				fw.close();
			}
		}
	}

	/*
	 * BufferedReaders/Writers are wrapping classes that make interpreting streams
	 * significantly easier. sort of like Scanner (in my opinion, scanner is better)
	 * They have the option to parse streams on a per line basis, or even on a
	 * custom buffer basis. When in doubt, if buffer is in the name, it is
	 * synchronized
	 */
	public void bufferedExample() throws IOException {
		try {
			br = new BufferedReader(new FileReader(FILE_NAME));
			bw = new BufferedWriter(
					new FileWriter(FILE_NAME.split("\\.")[0] + "_replaced." + FILE_NAME.split("\\.")[1]));

			String input = "";

			while ((input = br.readLine()) != null) {
				input = input.replaceAll("A", "REPLACED");
				input += '\n';
				bw.write(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
			if (bw != null) {
				bw.close();
			}
		}

	}

}
