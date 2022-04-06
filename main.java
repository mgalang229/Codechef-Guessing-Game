import java.io.*;
import java.util.*;

public class Main {
	
	private static FastReader in;
	
	public static void main(String[] args) {
		in = new FastReader();
		int tc = 1;
		tc = in.nextInt();
		for(int t = 0; t < tc; t++) {
			new Solver();
		}
	}
	
	/**
	 * Calculates the frequency of even numbers from 1 to x (inclusive)
	 * @param x
	 * @return
	 */
	static long getEven(long x) {
		return x / 2;
	}
	
	/**
	 * Calculates the frequency of odd numbers from 1 to x (inclusive)
	 * @param x
	 * @return
	 */
	static long getOdd(long x) {
		return (x % 2 == 0 ? x / 2 : x / 2 + 1);
	}
	
	/**
	 * Calculates the greatest common divisor of the
	 * two given numbers
	 * @param a
	 * @param b
	 * @return
	 */
	static long getGCD(long a, long b) {
		if(b == 0) {
			return a;
		}
		return getGCD(b, a % b);
	}
	
	static class Solver { 
		Solver() {
			
			// input
			long n = in.nextInt(), m = in.nextInt();
			
			// total no. of pair combinations
			long total = n * m;
			
			// remember to produce an odd number, the addends must have different parities
			long possible = (getEven(n) * getOdd(m)) + (getEven(m) * getOdd(n));
			
			// calculate the greatest common divisor (for getting the lowest term)
			long divisor = getGCD(possible, total);
			
			// output
			System.out.println((possible / divisor) + "/" + (total / divisor));
		}
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
