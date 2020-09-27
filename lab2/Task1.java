package lab2;

import java.util.*;

public class Task1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		while(!input.equals("")) {
			System.out.println(input);
			input = sc.nextLine();
		}
		sc.close();
	}
}
