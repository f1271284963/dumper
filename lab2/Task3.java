package lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) throws Exception{
		System.out.print("Enter the full file path to read: ");
		
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		
		sc.close();
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		double [][]Matrix = new double[4][5];
		
		String line;
		int row = 0;
		int col;
		
		try {
			while((line = br.readLine()) != null) {
				String allNumbers[] = line.split("");
				col = 0;
				for (String singleNumber : allNumbers) {
					Matrix[row][col] = Integer.parseInt(singleNumber);
					col = col + 1;
				}
				row = row + 1;
			}	
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		fr.close();
		br.close();
	}
}
