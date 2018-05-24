import processing.core.PApplet;

public class Display {
	private static final float DIAMETER = 10;
	public double screenXMin, screenXMax, screenYMin, screenYMax;
	public double dataXMin, dataXMax, dataYMin, dataYMax;
	
	public Display(double screenXMin, double screenXMax, double screenYMin, double screenYMax, double dataXMin,
			double dataXMax, double dataYMin, double dataYMax) {
		this.screenXMin = screenXMin;
		this.screenXMax = screenXMax;
		this.screenYMin = screenYMin;
		this.screenYMax = screenYMax;
		this.dataXMin = dataXMin;
		this.dataXMax = dataXMax;
		this.dataYMin = dataYMin;
		this.dataYMax = dataYMax;
	}

	public double map(double a, double b, double c, double d, double e) {
		return d - ((b-e)/(b-a))*(d-c);
	}
	
	public void plot(double dataX, double dataY, PApplet window, 
			int strokeColor, int fillColor, int thickness) {
		double screenX = map(dataXMin, dataXMax, screenXMin, screenXMax, dataX);
		double screenY = map(dataYMin, dataYMax, screenYMin, screenYMax, dataY);

		window.stroke(strokeColor);
		window.fill(fillColor);
		window.strokeWeight(thickness);
		window.ellipse((float)screenX, (float)screenY, DIAMETER, DIAMETER);
	}
	
}
