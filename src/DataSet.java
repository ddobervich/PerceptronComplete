import java.util.ArrayList;
import java.util.List;

public class DataSet {
	private ArrayList<DataPoint> points;
	DataPoint minValsPoint, maxValsPoint;

	public DataSet() {
		points = new ArrayList<DataPoint>();
		maxValsPoint = new DataPoint(new float[] { Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE },
				"");
		minValsPoint = new DataPoint(new float[] { Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE },
				"");
	}

	public void add(DataPoint p) {
		// Set new min/max values if necessary
		for (int i = 0; i < p.getData().length; i++) {
			float val = p.getData(i);
			if (val > maxValsPoint.getData(i))
				maxValsPoint.setData(i, val);
			if (val < minValsPoint.getData(i))
				minValsPoint.setData(i, val);
		}

		points.add(p);
	}

	public float getMinVal(int i) {
		return minValsPoint.getData(i);
	}

	public float getMaxVal(int i) {
		return maxValsPoint.getData(i);
	}

	public List<DataPoint> getData() {
		return points;
	}

	public int size() {
		return points.size();
	}

	public String toString() {
		String ret = "Points: " + points.size();
		ret += "\n\n" + points.toString();
		ret += "\n------------------------\n";
		ret += "Max: " + this.maxValsPoint + "\nMin: " + this.minValsPoint + "\n";

		return ret;
	}

	public void removeType(int labelToRemove) {
		for (int i = 0; i < points.size(); i++) {
			DataPoint p = points.get(i);
			
			if (p.getLabel() == labelToRemove) {
				points.remove(p);
				i--;
			}
		}
		
		// TODO: re-calculate max's and min's of data set
	}
}