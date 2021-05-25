package sort;

// 선택정렬
// 가장 작은 것을 찾아 맨 앞부터 스와핑
// 시간복잡도 : O(n^2)
/*
 * 1 10 5 8 7 6 4 3 2 9
 * 1 2 5 8 7 6 4 3 10 9
 * 1 2 3 8 7 6 4 5 10 9
 * :
 * 1 2 3 4 5 6 7 8 10 9
 * 1 2 3 4 5 6 7 8 9 10
 */
public class Sort01_SelectionSort {
	public static void main(String[] args) {
		int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		for(int i=0; i<arr.length; i++) {
			int min = arr[i];	// 최솟값
			int index = i;	// 최솟값의 위치
			for(int j=i+1; j<arr.length; j++) {
				if(min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			// 스와핑
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		for(int out : arr) {
			System.out.printf("%d ", out);
		}
	}
}
