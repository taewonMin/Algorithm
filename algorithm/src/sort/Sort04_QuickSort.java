package sort;

// 퀵 정렬
// 특정한 값을 기준으로 큰 숫자와 작은 숫자 그룹으로 나눈다(분할 정복 알고리즘)
// 시간복잡도 : O(N*logN), 최악의 경우(= 이미 정렬이 되어있는 데이터의 경우) O(N^2)
/*
 * 
 */
public class Sort04_QuickSort {
	public static void main(String[] args) {
		int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		
		for(int out : arr) {
			System.out.printf("%d ", out);
		}
	}
}
