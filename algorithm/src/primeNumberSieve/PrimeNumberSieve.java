package primeNumberSieve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 에라토스테네스의 체
public class PrimeNumberSieve {
	
	static List<Integer> primeNumberSieve(int num) {
		boolean[] primeArr = new boolean[num+1];
		Arrays.fill(primeArr, true);
		
		for(int i=2; i<primeArr.length; i++) {
			for(int j=i+i; j<=num; j+=i) {
				if(primeArr[j]) {
					primeArr[j] = false;
				}
			}
		}
		
		List<Integer> results = new ArrayList<Integer>();
		for(int i=2; i<primeArr.length; i++) {
			if(primeArr[i]) {
				results.add(i);
			}
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		List<Integer> primeList = primeNumberSieve(10);
		System.out.println(primeList);
	}
}
