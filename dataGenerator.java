import java.io.*;
import java.util.Random;

public class dataGenerator{
	/** Program name. */
	protected static final String progName = "DataGenerator";
	/** Random generator to use. */
	Random mRandGen;

	public static void main(String[] args){
		// check correct number of command line arguments	
		try {
			// integer range
			int startOfRange = Integer.parseInt(args[0]);
			int endOfRange = Integer.parseInt(args[1]);
			
			// number of values to sample
			int sampleSize = Integer.parseInt(args[2]);
			
			// type of sampling
			String samplingType = args[3];
			
			dataGenerator gen = new dataGenerator(startOfRange, endOfRange);
			
			int[] samples = null;
			switch (samplingType) {
				// sampling with replacement
				case "with":
					samples = gen.sampleWithReplacement(sampleSize);
					break;
				// sampling without replacement
				case "without":
					samples = gen.sampleWithOutReplacement(sampleSize);
					break;
				default:
					System.err.println(samplingType + " is an unknown sampling type.");
					usage();
			}
			
			// print out samples
			if (samples != null) {
				for (int i = 0; i < samples.length; i++) {
					System.out.print(samples[i] + " ");
				}
				System.out.println("");
			}
			
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			usage();
		}
	}
}
