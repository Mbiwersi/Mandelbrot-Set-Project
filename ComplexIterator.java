// Interface of ComplexIterator with Complex objects
//
//
//Author: Michael Biwersi

import java.util.NoSuchElementException;
/** Iterator of complex numbers. */
public interface ComplexIterator {
	
	/** Return the next value from the iterator.
	 * @throws NoSuchElementException if the iterator has no more elements.
	 */
	public Complex next();
	
	/** Check whether there is another value from the iterator.
	 */
	public boolean hasNext();
	}
