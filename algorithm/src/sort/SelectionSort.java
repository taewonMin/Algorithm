package sort;

// 선택정렬
// 가장 작은 것을 찾아 맨 앞부터 스와핑
// 시간복잡도 : O(n^2)
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		for(int i=0; i<arr.length; i++) {
			int min = arr[i];
			int index = i;
			for(int j=i+1; j<arr.length; j++) {
				if(min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		for(int out : arr) {
			System.out.printf("%d ", out);
		}
	}
}
