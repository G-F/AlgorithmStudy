/**
 * 挿入ソートを試す
 * 
 * @author masao
 *
 */
public class InsertSort {

	public static void main(String[] args) {

		int[] array = createRandomArray(Integer.parseInt(args[0]));

		// FIXME Java8の機能で書き直す
		System.out.println("整列前");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		insertSort(array);

		System.out.println("整列後");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * 挿入ソートで配列を整列する
	 * @param array
	 */
	private static void insertSort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			insert(array, i, array[i]);
		}
	}

	/**
	 * 挿入ソートの各回の操作
	 * @param array
	 * @param pos
	 * @param value
	 */
	private static void insert(int[] array, int pos, int value) {
		
		int index = pos - 1;
		while (index >= 0 && array[index] > value) {
			array[index + 1] = array[index];
			index--;
		}
		array[index+1] = value;
		
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

}
