//Counts the number of times that a function is applied to a complex number
//Returns the count if the value of the magnitude is past the threshold or the max number of iterations
//
//Author: Michael Biwersi

public class IterationCounter {
	/*
	*@param ComplexFunctionValuesIterator
	*@param double value representing the threshold value to which we compare the modulus of the values
	*generated by<code>ComplexFunctionValuesIterator</code> object
	*@param int value representing the maximum number of iterations
	*returns an int value, the number of calls to the next method before its result's
	*modulus exceeds the threshold value, up to the maximum number of iterations allowed
	*/
	
	public static int countIterations(ComplexFunctionValuesIterator cfvi, double value, int max) {
		int count=0;
		while(cfvi.hasNext()) {
			double mag = cfvi.next().getMagnitude();
			
			if(count==max||mag>value) {
				return count;
			}
			count++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// Tests
		Complex cp1 = Complex.cpl(9.0, 8.0);
		Complex cp2 = Complex.cpl(2.0, 3.0);
		MandelbrotBase mb1 = new MandelbrotBase(cp1);
		MandelbrotBase mb2 = new MandelbrotBase(cp1);
		MandelbrotBase mb3 = new MandelbrotBase(cp1);
		MandelbrotBase mb4 = new MandelbrotBase(cp1);
		ComplexFunctionValuesIterator cpf1 = new ComplexFunctionValuesIterator(mb1, cp1);
		ComplexFunctionValuesIterator cpf2 = new ComplexFunctionValuesIterator(mb2, cp1);
		ComplexFunctionValuesIterator cpf3 = new ComplexFunctionValuesIterator(mb3, cp1);
		ComplexFunctionValuesIterator cpf4 = new ComplexFunctionValuesIterator(mb4, cp2);
		System.out.println("Testing the result of the ItererationCounter(cpf1, 100.0, 100) method of the complex number 9.0+8.0i\nexpecting, 1 result: "+IterationCounter.countIterations(cpf1, 100.0, 100));
		System.out.println("Testing the result of the ItererationCounter(cpf2, 1000.0, 100) method of the complex number 9.0+8.0i\nexpecting, 2 result: "+IterationCounter.countIterations(cpf2, 1000.0, 100));
		System.out.println("Testing the result of the ItererationCounter(cpf3, 100000.0, 1) method of the complex number 9.0+8.0i\n expecting, 1 result: "+IterationCounter.countIterations(cpf3, 100000.0, 1));
		System.out.println("Testing the result of the ItererationCounter(cpf4, 900000000000.0, 2) of the Complex number 2.0+3.0i method \nexpecting, 2 result: "+IterationCounter.countIterations(cpf4, 900000000000.0, 2));

	}

}