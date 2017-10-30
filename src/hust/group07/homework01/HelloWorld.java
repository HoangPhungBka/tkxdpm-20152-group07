package hust.group07.homework01;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloWorld {
	
	private String name;
	private int yearOfBirth;
	
	/*
	 * Yêu cầu người dùng nhập vào tên và năm sinh của họ và lưu vào các thuộc tính tương ứng.
	 */
	public void setAttributes() {
		String nameInput = ""; int yearInput = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập vào tên của bạn: ");
		try {
			nameInput = scanner.nextLine();
		} catch (InputMismatchException e) {
			System.err.println("Đây không phải là tên của bạn!");
		}
		System.out.println("Nhập vào năm sinh của bạn: ");
		try {
			yearInput = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Đây không phải là năm sinh của bạn!");
		}
		name = nameInput; yearOfBirth = yearInput;
		scanner.close();
	}
	
	/*
	 * Say hello tới user và in ra console tuổi của họ (sử dụng minus method trong ComplexNumber).
	 */
	public void sayHello() {
		System.out.println("Hello: " + this.name);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        ComplexNumber firstNumber = new ComplexNumber(this.yearOfBirth, 0);
		ComplexNumber secondNumber = new ComplexNumber(currentYear, 0);
		System.out.println("Your age is: "); secondNumber.minus(firstNumber).print();
	}
}
