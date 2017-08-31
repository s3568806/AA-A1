import java.io.*;
import java.util.Random;

public class dataGenerator{
	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("number of arguments insufficient");
			System.exit(1);
		}
		
		int size = Integer.parseInt(args[0]);
		Random mRandGen = new Random();
		for (int i = 0; i < size; i ++){
			int n = mRandGen.nextInt(100) + 1;		
			System.out.print(n + " ");
		}
	}
}
