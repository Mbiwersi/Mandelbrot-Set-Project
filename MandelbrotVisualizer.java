//Creates a visual representation of the Mandelbrot set
//
//
//Author: Michael Biwersi

import java.awt.Color;

public class MandelbrotVisualizer extends DrawingPad{

	public MandelbrotVisualizer(int width, int height, Complex topLeft, Complex bottomRight, int[] intArray, Color[] colorArray, double threshold) {
		super(width, height);
		double domain = (Math.sqrt(Math.pow(topLeft.getReal(),2)))+(Math.sqrt(Math.pow(bottomRight.getReal(),2)));
		double range = (Math.sqrt(Math.pow(topLeft.getImaginary(),2))+(Math.sqrt(Math.pow(bottomRight.getImaginary(),2))));
		double pixelDomain = domain/(width);
		double pixelRange = range/(height);
		int xCount = 0;
		for(double i = topLeft.getReal(); i<=bottomRight.getReal(); i+=pixelDomain) {
			int yCount=0;
			for(double j = topLeft.getImaginary(); j>= bottomRight.getImaginary();j-=pixelRange) {
				Complex pixel = Complex.cpl(i, j);
				MandelbrotBase mbb1 = new MandelbrotBase(pixel);
				ComplexFunctionValuesIterator cfvi = new ComplexFunctionValuesIterator(mbb1, pixel);
				int iterations = IterationCounter.countIterations(cfvi, threshold, intArray[intArray.length-1]);
				super.drawRect(colorArray[iterations], xCount, yCount, 1, 1);
				yCount+=1;
			}
			xCount++;
		}
	}
	public static void main(String[]args) {
		
		//creates the color Array that will be used for the color of the pixel according to how many iterations at that pixel
		Color[] colorArray3 ={Color.red, Color.orange, Color.blue,Color.green,Color.pink,Color.MAGENTA,Color.cyan,Color.LIGHT_GRAY, Color.GRAY,
				Color.red, Color.orange, Color.blue,Color.green,Color.pink,Color.MAGENTA,Color.cyan,Color.LIGHT_GRAY, Color.GRAY,
				Color.red, Color.orange, Color.blue,Color.green,Color.pink,Color.MAGENTA,Color.cyan,Color.LIGHT_GRAY, Color.GRAY,
				Color.red, Color.orange, Color.blue,Color.green,Color.pink,Color.MAGENTA,Color.cyan,Color.LIGHT_GRAY, Color.GRAY, Color.black};
		int[] intArray4 = new int[colorArray3.length];
		for(int i=0; i <colorArray3.length; i++) {
			intArray4[i]=i;
		}
		
		//setting the borders of the frame
		Complex topLeft = Complex.cpl(-2.5, 1.25);
		Complex bottomRight = Complex.cpl(1, -1.25);
		
		//creating a new MandelbroVisualizer which creates the Jfame and prints the Mandelbrot set
		MandelbrotVisualizer m1 = new MandelbrotVisualizer(500,500, topLeft, bottomRight, intArray4, colorArray3, 20);
		
		
	}
}
