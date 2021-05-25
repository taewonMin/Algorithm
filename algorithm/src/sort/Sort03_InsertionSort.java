package sort;

// 삽입정렬
// 각 원소를 적절한 위치에 삽입(왼쪽은 이미 정렬되어있다고 가정하기때문에 선택,버블 정렬보다 빠르다)
// 데이터가 거의 정렬되어있는 경우에 속도가 어떤 알고리즘보다도 빠름
// 시간복잡도 : O(n^2)
/*
 * 1 (10) 5 8 7 6 4 3 2 9
 * 1 (5) 10 8 7 6 4 3 2 9
 * 1 5 (8) 10 7 6 4 3 2 9
 * 1 5 (7) 8 10 6 4 3 2 9
 * :
 * 1 2 (3) 4 5 6 7 8 10 9
 * 1 2 3 4 5 6 7 8 (9) 10
 */
public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		for(int i=0; i<arr.length-1; i++) {
			int j = i;
			while(j >= 0 && arr[j] > arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				j--;
			}
		}
		
		for(int out : arr) {
			System.out.printf("%d ", out);
		}
	}
}
