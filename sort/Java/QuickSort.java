public class QuickSort {

	public static void main(String[] args) {

		int[] array = createRandomArray(Integer.parseInt(args[0]));

		System.out.println("����O");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		quickSort(array, 0, array.length - 1);

		System.out.println("�����");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	/**
	 * �N�C�b�N�\�[�g�Ŕz��̎w�肳�ꂽ�͈͂𐮗񂷂�
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
	 * ����I�����Ĕz������l�ŕ�������
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] array, int left, int right) {
		// ���l�͍��[�ƉE�[�̒��Ԓl�ɂ���
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
	 * int�^�̔z��ɗ������i�[����
	 * 
	 * @param num
	 * @return �������������̔z��
	 */
	private static int[] createRandomArray(int num) {

		int[] result = new int[num];

		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random() * 100);
		}

		return result;
	}

	/**
	 * �z��̗v�f�����ւ���
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
