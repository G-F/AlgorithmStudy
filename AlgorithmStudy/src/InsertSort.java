/**
 * �}���\�[�g������
 * 
 * @author masao
 *
 */
public class InsertSort {

	public static void main(String[] args) {

		int[] array = createRandomArray(Integer.parseInt(args[0]));

		// FIXME Java8�̋@�\�ŏ�������
		System.out.println("����O");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		insertSort(array);

		System.out.println("�����");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * �}���\�[�g�Ŕz��𐮗񂷂�
	 * @param array
	 */
	private static void insertSort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			insert(array, i, array[i]);
		}
	}

	/**
	 * �}���\�[�g�̊e��̑���
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

}
