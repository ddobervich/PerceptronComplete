import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Main extends PApplet {	
	DataSet d;

	public void setup() {
		size(800, 800);

		String[] headers = { "sepal length", "sepal width", "petal length", "petal width", "class" };
		d = DataReader.createDataSet("iris.data", 0, headers);


	}

	public void draw() {
		background(200);
	
	}
}
