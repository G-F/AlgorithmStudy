/**
 * }ü\[gð·
 * 
 * @author masao
 *
 */
public class InsertSort {

	public static void main(String[] args) {

		int[] array = createRandomArray(Integer.parseInt(args[0]));

		// FIXME Java8Ì@\Å«¼·
		System.out.println("®ñO");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		insertSort(array);

		System.out.println("®ñã");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * }ü\[gÅzñð®ñ·é
	 * @param array
	 */
	private static void insertSort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			insert(array, i, array[i]);
		}
	}

	/**
	 * }ü\[gÌeñÌì
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
	 * int^ÌzñÉði[·é
	 * 
	 * @param num
	 * @return ¶¬µ½Ìzñ
	 */
	private static int[] createRandomArray(int num) {

		int[] result = new int[num];

		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random() * 100);
		}

		return result;
	}

}
