import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Comparator.*;

public class MedianSort {

	public static void main(String[] args) {

		int[] array = createRandomArray(Integer.parseInt(args[0]));

		System.out.println("����O");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		medianSort(array, 0, array.length - 1);

		System.out.println("�����");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * �����l�\�[�g
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	private static void medianSort(int[] array, int start, int end) {

		// �\�[�g�Ώۂ̎w�肪����Ă���ΏI��
		if (start >= end) {
			return;
		}

		// �����̃C���f�b�N�X���擾����
		int medianIndex = (start + end) / 2;

		// �����l�̏ꏊ���擾
		int medianPosition = findNthValue(array, medianIndex,
				nullsFirst(naturalOrder()));

		// �����l�𒆉��Ɏ����Ă���
		swap(array, medianIndex, medianPosition);

		for (int i = start; i < medianIndex; i++) {
			if (array[i] > array[medianIndex]) {
				int rightIndex = findFirstSmallValue(Arrays.copyOfRange(array,
						medianIndex + 1, array.length), array[medianIndex]);
				if (rightIndex < 0) {
					throw new RuntimeException("�E�ӂ̔z��ɕϊ��p�̒l��������܂���ł���");
				}
				int toIndex = rightIndex + medianIndex + 1;
				swap(array, i, toIndex);
			}
		}

		medianSort(array, start, medianIndex - 1);
		medianSort(array, medianIndex + 1, end);

	}

	/**
	 * �z����̑�������菬�����ŏ��̒l��Ԃ�
	 * 
	 * @param array
	 * @param value
	 * @return
	 */
	private static int findFirstSmallValue(int[] array, int value) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] < value) {
				return i;
			}
		}

		return -1;
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

	/**
	 * �z������w�肳�ꂽ���Ԃɕ��וς�������n�Ԗڂ̒l�̔z����ł̈ʒu��Ԃ�
	 * 
	 * @param array
	 * @param nth
	 * @param comparator
	 * @return
	 */
	private static int findNthValue(int[] array, int nth,
			Comparator<Integer> comparator) {

		List<Integer> list = new ArrayList<>();
		for (int i : array) {
			list.add(i);
		}

		// FIXME Java�̕W��API�̃\�[�g�@�\���g���Ă��邪�����͒����l�\�[�g�̖{�؂ł͂Ȃ��̂ł������񋖗e
		// ���ƂŁA�����l���������郍�W�b�N�ɏ�������
		List<Integer> sortedList = list.stream().sorted(comparator)
				.collect(Collectors.toList());

		int nthValue = sortedList.get(nth);

		return list.indexOf(nthValue);

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
