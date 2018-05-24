public class Perceptron {
	private float[] weights;
	private float THRESHOLD;
	private float learningRate = 0.005f;
	private int numInputs;

	public Perceptron(int numInputs) {
		this.numInputs = numInputs;
		weights = new float[numInputs];

		initWeightsRandomly();
	}

	// Init weights randomly between [-1, 1)
	private void initWeightsRandomly() {
		THRESHOLD = (float) (-1 + 2 * Math.random());

		for (int i = 0; i < weights.length; i++) {
			weights[i] = (float) (-1 + 2 * Math.random());
		}
	}

	public void train(float[] input, int correctLabel) {
		// make a guess
		int guess = guess(input);

		// if it's wrong, adjust weights
		if (guess != correctLabel) {
			float error = guess - correctLabel;

			for (int i = 0; i < weights.length; i++) {
				weights[i] = weights[i] - error * input[i] * learningRate;
			}

			THRESHOLD = THRESHOLD + error * learningRate;
		}
	}

	public int guess(float[] input) {
		float sum = 0;

		for (int i = 0; i < input.length; i++) {
			sum += input[i] * weights[i];
		}

		return activationFunction(sum);
	}

	private int activationFunction(float sum) {
		if (sum > THRESHOLD) {
			return 1;
		} else {
			return 0;
		}
	}

	public float[] getWeights() {
		return weights;
	}
}
