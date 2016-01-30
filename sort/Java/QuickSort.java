public class QuickSort {

	public static void main(String[] args) {

		int[] array = createRandomArray(Integer.parseInt(args[0]));

		System.out.println("整列前");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		quickSort(array, 0, array.length - 1);

		System.out.println("整列後");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	/**
	 * クイックソートで配列の指定された範囲を整列する
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	private static void quickSort(int[] array, int left, int right) {

		if (left >= right) {
			return;
		}

		int axis = partition(array, left, right);

		quickSort(array, left, axis - 1);
		quickSort(array, axis + 1, right);
	}

	/**
	 * 軸を選択して配列を軸値で分割する
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] array, int left, int right) {
		// 軸値は左端と右端の中間値にする
		int axis = left + ((right - left) / 2);

		swap(array, right, axis);
		int store = left;

		for (int i = left; i < right; i++) {
			if (array[i] <= array[right]) {
				swap(array, i, store);
				store++;
			}
		}
		swap(array, store, right);

		return store;
	}

	/**
	 * int型の配列に乱数を格納する
	 * 
	 * @param num
	 * @return 生成した乱数の配列
	 */
	private static int[] createRandomArray(int num) {

		int[] result = new int[num];

		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random() * 100);
		}

		return result;
	}

	/**
	 * 配列の要素を入れ替える
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	private static void swap(int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
}
