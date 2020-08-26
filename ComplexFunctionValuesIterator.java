//Class that implements ComplexIterator with Complex objects next() method along with
//hasNext()
//
//Author: Michael Biwersi

import java.util.NoSuchElementException;
public class ComplexFunctionValuesIterator implements ComplexIterator {
	private Complex i;
	private ComplexFunction h;
	/*Constructor takes
	*@param <code>ComplexFunction</code> h.
	*@param <code>Complex</code> initial value i.
	*/
	public ComplexFunctionValuesIterator(ComplexFunction h, Complex i) {
		this.i= i;
		this.h= h;
	}
	
	//method should return first just i, then h(i), then h(h(i)), then h(h(h(i))), an so on
	//keeping the last returned value, and applying h to it one more time at the following call to <code>next</code>
	public Complex next() {
		if(this.hasNext()) {
			Complex current = i;
			i = h.apply(i);
			return current;
		}
		throw new NoSuchElementException();
	}
	
	//should always return <code>true</code>:there should always be a valid next value.
	public boolean hasNext() {
		return true;
	}
	
	public static void main(String[]arg) {
		//Tests
		Complex cp1= Complex.cpl(14, 17);
		MandelbrotBase mbb1 = new MandelbrotBase(cp1);
		ComplexFunctionValuesIterator cfvi = new ComplexFunctionValuesIterator(mbb1, cp1);
		System.out.println("Printing the result of next().getReal() expecting 14 , result: "+cfvi.next().getReal());
		System.out.println("Printing the result of next().getImaginary() expecting 493.0 , result: "+cfvi.next().getImaginary());
		System.out.println("Print the result of hasNext() expecing true, result: "+cfvi.hasNext());

	}

}
