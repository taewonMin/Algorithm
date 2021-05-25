package sort;

// 버블 정렬
// 옆에 있는 값과 비교하여 더 작은 값을 앞으로 보내는 정렬(각 싸이클마다 가장 큰 값이 뒤쪽부터 정렬됨)
// 시간복잡도 : O(n^2), 모든 정렬 중에 가장 효율이 떨어짐
/*
 * 1 사이클
 * 1 10 5 8 7 6 4 3 2 9
 * 1 5 10 8 7 6 4 3 2 9
 * 1 5 8 10 7 6 4 3 2 9
 * 1 5 8 7 10 6 4 3 2 9 
 * :
 * 1 5 8 7 6 4 3 2 9 10
 * 
 * 2 사이클
 * 1 5 8 7 6 4 3 2 9 10
 * 1 5 8 7 6 4 3 2 9 10
 * 1 5 7 8 6 4 3 2 9 10
 * 1 5 7 6 8 4 3 2 9 10
 * 1 5 7 6 4 8 3 2 9 10
 * :
 * 1 5 7 6 4 3 2 8 9 10
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(int out : arr) {
			System.out.printf("%d ", out);
		}
	}
}
