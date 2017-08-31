import java.io.*;
import java.util.Random;

public class dataGenerator{
	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("number of arguments insufficient");
			System.exit(1);
		}
		
		try{
			PrintWriter writer = new PrintWriter("randomsample.in", "UTF-8");
			int size = Integer.parseInt(args[0]);
			Random mRandGen = new Random();
			for (int i = 0; i < size; i ++){
				int n = mRandGen.nextInt(10000) + 1;	
				System.out.print(n + " ");
				writer.println(n);
			}
			writer.close();
		}
		catch(IOException e){
			System.out.println("file failed to create");
			System.exit(1);
		}
	}
}
