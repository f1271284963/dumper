package lab2;

import java.io.*;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) throws Exception{
		System.out.print("Enter the full file path to read: ");
		
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		
		sc.close();
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		String str;
		try {
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		fr.close();
		br.close();
		}
	}
