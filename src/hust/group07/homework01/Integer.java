package hust.group07.homework01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Integer {
	
	private int integer;
	
	/*
	 * Phương thức này yêu cầu người dùng nhập vào một số int từ console, sau đó kiểm tra xem
	 * số đó có kiểu int hay ko, nếu ko thì yêu cầu nhập lại, nếu có thì lưu vào thuộc tính integer.
	 */
	public void setInteger() {
		int input = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập vào một số nguyên: ");
		try {
			input = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Không phải là số int!");
		}
		integer = input;
		scanner.close();
	}
	
	/*
	 * Phương thức này kiểm tra xem số int người dùng nhập vào có phải là số nguyên tố hay ko?
	 * Trả về true nếu số đó là số nguyên tố, false nếu ngược lại.
	 */
	public boolean isPrimeNumber() {
		if (integer < 2) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(integer); i++) {
			if ((integer % i) == 0) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Phương thức này kiểm tra xem số int người dùng nhập vào có phải là sô chính phương hay ko?
	 * Trả về true nếu số đó là số chính phương, false nếu ngược lại.
	 */
	public boolean isSquareNumber() {
		int sqrt = (int) Math.sqrt(integer);
		int square = (int) Math.pow(sqrt, 2);
		if (square == integer) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Phương thức này kiểm tra xem số int người dùng nhập vào có phải là số hoàn hảo hay ko?
	 * Trả về true nếu số đó là số hoàn hảo, false nếu ngược lại.
	 */
	public boolean isPerfectNumber() {
		int count = 0;
		for (int i = 1; i < integer; i++) {
			if ((integer % i) == 0) {
				count += i;
			}
		}
		if (count == integer) {
			return true;
		} else {
			return false;
		}
	}
}
