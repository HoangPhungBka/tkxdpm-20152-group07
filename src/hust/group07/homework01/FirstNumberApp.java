package hust.group07.homework01;

public class FirstNumberApp {
	
	private Integer integer = new Integer();

	/*
	 * Sử dụng setInteger method trong lớp Integer để yêu cầu người dùng nhập vào một số int.
	 */
	public void inputNumber() {
		integer.setInteger();
	}
	
	/*
	 * In ra màn hình số người dùng nhập vào có phải là số nguyên tố, số chính phương
	 * hay số hoàn hảo hay ko bằng cách sử dụng các phương thức trong lớp Integer.
	 */
	public void display() {
		if (integer.isPrimeNumber()) {
			System.out.println("Số nguyên tố!");
		} else {
			System.out.println("Không phải là số nguyên tố!");
		}
		if (integer.isSquareNumber()) {
			System.out.println("Số chính phương!");
		} else {
			System.out.println("Không phải là số chính phương!");
		}
		if (integer.isPerfectNumber()) {
			System.out.println("Số hoàn hảo!");
		} else {
			System.out.println("Không phải là số hoàn hảo!");
		}
	}
}
