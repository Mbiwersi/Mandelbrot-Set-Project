/* Complex.java
 *
 * specification of methods supported for complex numbers.
 *
 * Author: John Maraist
 * 
 * **Method studs were given by instructor. Methods were filled by Michael Biwersi**
 *
 * First, add dummy values to allow this class to compile as-is.  Next
 * write a main method with sample calls to these methods, printing
 * results to make sure that the implementation is correct.  Finally,
 * design the methods, then add a constructor, fields and method body
 * implementations to complete this class.
 */

/**
 * Complex numbers and arithmetic.
 */
public class Complex {
private double real;
private double imaginary;

  //Constructor
  public Complex (double real, double imaginary) {
	  this.real = real;
	  this.imaginary = imaginary;
}
  /** A convenience method, shorter than a constructor call, for
   * creating complex numbers.
   * @param real The real component of the number.
   * @param imaginary The imaginary component of the number.
   * @return An immutable instance of <code>Complex</code>
   * representing the indicated number.
   */
  public static Complex cpl(double real, double imaginary) {
	  return new Complex(real, imaginary);
  }

  /** The real component of this number. */
  public double getReal() {
	  return this.real;
  }

  /** The imaginary component of this number. */
  public double getImaginary(){
	  return this.imaginary;
  }

  /** Returns <code>true</code> if this number is zero.  */
  public boolean isZero(){
	  if((real+imaginary)==0) {
		  return true;
	  }
	  return false;
  }

  /** The magnitude (also called modulus or absolute value) of this
   * number, calculated as the square root of the sum of the square of
   * the real component and the square of the imaginary component.  */
  public double getMagnitude(){
	  return Math.sqrt((real*real)+(imaginary*imaginary));
	  //return -999.99;
  }

  /** Returns the sum of this number and <code>that</code>.  Does not
   * change either <code>this</code> or the argument.  We use the
   * standard definition of complex arithmetic; see for example
   * http://mathworld.wolfram.com/ComplexNumber.html .  */
  public Complex add(Complex that){
	  this.real += that.getReal();
	  this.imaginary += that.getImaginary();
	  return new Complex(real, imaginary);
  }

  /** Returns the difference of this number and <code>that</code>.
   * Does not change either <code>this</code> or the argument.  We use the
   * standard definition of complex arithmetic; see for example
   * http://mathworld.wolfram.com/ComplexNumber.html .  */
  public Complex subtract(Complex that){
	  this.real-= that.getReal();
	  this.imaginary-=that.getImaginary();
	  return new Complex(this.real,this.imaginary);
  }

  /** Returns the product of this number and <code>that</code>.  Does
   * not change either <code>this</code> or the argument.  We use the
   * standard definition of complex arithmetic; see for example
   * http://mathworld.wolfram.com/ComplexNumber.html .  */
  public Complex multiply(Complex that){
	  double tempReal =(this.real*that.real)-(this.imaginary*that.imaginary);
	  double tempImaginary=(this.real*that.imaginary)+(this.imaginary*that.real);
	  return new Complex(tempReal, tempImaginary);
  }

  /** Returns the quotient of this number over <code>that</code>.
   * Does not change either <code>this</code> or the argument.  We use
   * the standard definition of complex arithmetic; see for example
   * http://mathworld.wolfram.com/ComplexNumber.html .  */
  public Complex dividedBy(Complex that){
	  double tempReal= ((this.real*that.real)+(this.imaginary*that.imaginary))/((that.real*that.real)+(that.imaginary*that.imaginary));
	  double tempImaginary=((this.imaginary*that.real)-(this.real*that.imaginary))/((that.real*that.real)+(that.imaginary*that.imaginary));
	  return new Complex(tempReal, tempImaginary);
  }

	public static void main(String[] args) {
		//Tests for compile (pre-implementation)
		/**Complex cp1 = new Complex(0.0,0.0);
		*System.out.println("printing the getReal() method: "+cp1.getReal());
		*System.out.println("printing the getImginary() method: "+cp1.getImaginary());
		*System.out.println("printing the getMagnitude() method: "+cp1.getMagnitude());
		*System.out.println("printing the cpl() method: "+cpl(3.14,3.1415));
		*System.out.println("Printing the isZero() method: "+cp1.isZero());
		*System.out.println("Printing the add(Complex) method: "+cp1.add(cp1));
		*System.out.println("Printing the subtract(Complex) method: "+cp1.subtract(cp1));
		*System.out.println("Printing the multiply(Complex) method: "+cp1.multiply(cp1));
		System.out.println("Printing the divideBy(Complex) method: "+cp1.dividedBy(cp1));*/
		
	//Tests for post-implementation
		//Testing the isZero()
		Complex testcp11= Complex.cpl(-2.0,2.0);
		System.out.println("Printing the result of the isZero() method, expecting true, result: "+testcp11.isZero());
		//Testing the getMagnitude()
		Complex testcp10 = Complex.cpl(33.3, 77.7);
		System.out.println("Printing the result of the getMagnitude() method, expecting 84.5350, result: "+testcp10.getMagnitude());
		//Testing the add()
		Complex testcp1 = Complex.cpl(10.0, 11.0);
		Complex testcp2 = Complex.cpl(5.0, 6.0);
		testcp1 = (testcp1.add(testcp2));
		System.out.println("Printing the add(Complex) method of testcp1 and testcp2, expecting 15.0 + 17.0i."
				+ " Result: "+testcp1.getReal()+" + "+
				testcp1.getImaginary()+"i");
		//Testing the subtract()
		Complex testcp3 = Complex.cpl(2.0, 3.0);
		Complex testcp4 = Complex.cpl(4.0, 6.0);
		Complex testcp5 = (testcp3.subtract(testcp4));
		System.out.println("Printing the subtract(Complex) method of testcp3 and testcp4, expecting -2.0 + -3.0i."
				+ " Result: "+testcp5.getReal()+" + "+
				testcp5.getImaginary()+"i");
		//Testing the multiply()
		Complex testcp6 = Complex.cpl(8.0, 9.0);
		Complex testcp7 = Complex.cpl(6.0, 3.0);
		testcp6 = (testcp6.multiply(testcp7));
		System.out.println("Printing the multiply(Complex) method of testcp6 and testcp7, expecting 21.0 + 78.0i"
				+ " Result: "+testcp6.getReal()+" + "+
				testcp6.getImaginary()+"i");
		//Testing the divideBy()
		Complex testcp8 = Complex.cpl(13.0, 17.0);
		Complex testcp9 = Complex.cpl(11.0, 10.0);
		testcp9 = (testcp8.dividedBy(testcp9));
		System.out.println("Printing the divideBy(Complex) method of testcp8 divide by testcp9, expecting 1.416 + 0.25791i"
				+ " Result: "+testcp9.getReal()+" + "+
				testcp9.getImaginary()+"i");
	}

}
