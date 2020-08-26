//Implements ComplexFunction and creates the function of fc(x)=x^2+c
//
//Author: Michael Biwersi
public class MandelbrotBase implements ComplexFunction {
	private Complex base;
	//Constructor and sets Base to the argument.
	public MandelbrotBase(Complex c) {
		base = c;
	}
	//Applies the function f(Base)(arg) = arg^2+Base
	public Complex apply(Complex arg) {
		Complex tempSquared = arg.multiply(arg);
		return (tempSquared.add(base));
	}
	public static void main(String[] args) {
		//Test
		Complex testcp1 =new Complex(8.0, 9.0);
		Complex testcp2 = new Complex(3.0, 5.0);
		MandelbrotBase md1 = new MandelbrotBase(testcp1);
		System.out.println("Testing the apply() method: expecting: -8.0 + 39.0i. Result: "
		+md1.apply(testcp2).getReal()+"+"+md1.apply(testcp2).getImaginary()+"i");

	}

}
