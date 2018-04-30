import java.util.Arrays;

public class DataPoint {
	// Data Labels
	public static final int iris_setosa = 1;
	public static final int iris_versicolor = 0;
	public static final int iris_virginica = 2;

	private float[] data;
	private String label;

	public DataPoint(float[] data, String label) {
		this.data = data;
		this.label = label;
	}

	public float[] getData() {
		return data;
	}

	public void setData(float[] data) {
		this.data = data;
	}

	public String getLabelString() {
		return label;
	}

	public int getLabel() {
		if (label.equals("Iris-setosa"))
			return iris_setosa;
		if (label.equals("Iris-versicolor"))
			return iris_versicolor;
		if (label.equals("Iris-virginica"))
			return iris_virginica;

		return -1;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getData(int i) {
		return data[i];
	}

	public void setData(int i, float val) {
		data[i] = val;
	}

	public String toString() {
		return Arrays.toString(data) + ": " + label + "\n";
	}
}
