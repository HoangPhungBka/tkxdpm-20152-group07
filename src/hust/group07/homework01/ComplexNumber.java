package hust.group07.homework01;

public class ComplexNumber {
	
	private double real, imaginary;
	
	/*
	 * Phương thức khởi tạo mặc định
	 */
	public ComplexNumber() {
		this.real = 0; this.imaginary = 0;
	}
	
	/*
	 * Phương thức khởi tạo với 2 tham sô
	 */
	public ComplexNumber(double real, double imaginary) {
		this.real = real; this.imaginary = imaginary;
	}
	
	/*
	 * Phương thức này in số phức ra console với định dạng: a + bi
	 */
	public void print() {
		if (this.imaginary != 0) {
			System.out.println(this.real + " + " + this.imaginary + "i");
		} else {
			System.out.println(this.real);
		}
	}
	
	/*
	 * Phương thức này cộng 2 số phức với nhau, trả về tổng của 2 số
	 */
	public ComplexNumber plus(ComplexNumber complexNumber) {
		ComplexNumber plusComplexNumber = new ComplexNumber();
		plusComplexNumber.real = this.real + complexNumber.real;
		plusComplexNumber.imaginary = this.imaginary + complexNumber.imaginary;
		return plusComplexNumber;
	}
	
	/*
	 * Phương thức này trừ 2 số phức, tham số đầu vào là sô trừ, trả về hiệu của 2 số
	 */
	public ComplexNumber minus(ComplexNumber complexNumber) {
		ComplexNumber minusComplexNumber = new ComplexNumber();
		minusComplexNumber.real = this.real - complexNumber.real;
		minusComplexNumber.imaginary = this.imaginary - complexNumber.imaginary;
		return minusComplexNumber;
	}
	
	/*
	 * Phương thức này nhân 2 số phức với nhau, trả về tích của 2 số
	 */
	public ComplexNumber times(ComplexNumber complexNumber) {
		ComplexNumber tempComplexNumber = new ComplexNumber();
		tempComplexNumber.real = this.real * complexNumber.real - this.imaginary * complexNumber.imaginary;
		tempComplexNumber.imaginary = this.real * complexNumber.imaginary + this.imaginary * complexNumber.real;
		return tempComplexNumber;
	}
	
	/*
	 * Phương thức này chia 2 số phức, tham số đầu vào là số chia, trả về thương của 2 số
	 */
	public ComplexNumber divides(ComplexNumber complexNumber) {
		complexNumber.imaginary = -complexNumber.imaginary;
		ComplexNumber tempComplexNumber = times(complexNumber);
		double squaredModule = Math.pow(complexNumber.real, 2) + Math.pow(complexNumber.imaginary, 2);
		tempComplexNumber.real = tempComplexNumber.real / squaredModule;
		tempComplexNumber.imaginary = tempComplexNumber.imaginary / squaredModule;
		return tempComplexNumber;
	}
	
	/*
	 * Phương thức này cộng 1 số phức với 1 số thực, trả về tổng của 2 số
	 */
	public ComplexNumber plus(double realNumber) {
		ComplexNumber plusComplexNumber = new ComplexNumber();
		plusComplexNumber.real = this.real + realNumber;
		return plusComplexNumber;
	}
	
	/*
	 * Phương thức main() dùng để kiểm tra các phương thức ở trên.
	 */
	public static void main(String[] args) {
		ComplexNumber firstNumber = new ComplexNumber(2, 3);
		ComplexNumber secondNumber = new ComplexNumber(4, 5);
		System.out.print("Tổng của 2 số phức: "); firstNumber.plus(secondNumber).print();
		System.out.print("Hiệu của 2 số phức: "); firstNumber.minus(secondNumber).print();
		System.out.print("Tích của 2 số phức: "); firstNumber.times(secondNumber).print();
		System.out.print("Thương của 2 số phức: "); firstNumber.divides(secondNumber).print();
		System.out.print("Tổng của sô phức với số thực: "); firstNumber.plus(3).print();
	}
}
