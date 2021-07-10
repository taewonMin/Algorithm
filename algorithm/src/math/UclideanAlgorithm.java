package math;

public class UclideanAlgorithm {
	public static void main(String[] args) {
		System.out.println(GCD(24,9));
	}
	
	static int GCD(int a, int b) {
		return a % b == 0 ? b : GCD(b, a%b);
	}
}
