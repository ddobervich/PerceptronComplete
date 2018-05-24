import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Main extends PApplet {
	DataSet d;
	Perceptron nn;
	Display display;

	public void setup() {
		size(800, 800);

		String[] headers = { "sepal length", "sepal width", "petal length", "petal width", "class" };
		d = DataReader.createDataSet("iris.data", 0, headers);

		nn = new Perceptron(2);

		// REMOVE THE ONE THAT YOU LABELED AS 2
		d.removeType(DataPoint.iris_versicolor);
		
		display = new Display(0, 800, 0, 800, 
							  -1, 10, -1, 10);
		

		for (int epochs = 0; epochs < 10; epochs++) {
			for (DataPoint p : d.getData()) {
				int correctLabel = p.getLabel();
				float[] input = { p.getData(0), p.getData(1)};

				nn.train(input, correctLabel);
			}
		}

		int numRight = 0;
		for (DataPoint p : d.getData()) {
			int correctLabel = p.getLabel();

			float[] input = { p.getData(0), p.getData(1) };

			int guess = nn.guess(input);

			if (guess == correctLabel) {
				numRight++;
			}

			//System.out.println("Guessed: " + guess + " real: " + correctLabel);
		}

		System.out.println("Right: " + numRight + " / " + d.getData().size());
	}

	public void draw() {
		background(200);
		int strokeColor = 0;
		int fillColor;
		
		for (DataPoint p : d.getData()) {
			
			int guess = nn.guess(new float[] { p.getData(0), p.getData(1) });
			
			if (guess == p.getLabel()) {
				fillColor = color(0, 255, 0);
			} else {
				fillColor = color(255, 0, 0);
			}
			
			display.plot(p.getData(0), p.getData(1), this, 
					strokeColor, fillColor, 2);
		}
	}
}
