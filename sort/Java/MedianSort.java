import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Comparator.*;

public class MedianSort {

	public static void main(String[] args) {

		int[] array = createRandomArray(Integer.parseInt(args[0]));

		System.out.println("整列前");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		medianSort(array, 0, array.length - 1);

		System.out.println("整列後");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * 中央値ソート
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	private static void medianSort(int[] array, int start, int end) {

		// ソート対象の指定が誤っていれば終了
		if (start >= end) {
			return;
		}

		// 中央のインデックスを取得する
		int medianIndex = (start + end) / 2;

		// 中央値の場所を取得
		int medianPosition = findNthValue(array, medianIndex,
				nullsFirst(naturalOrder()));

		// 中央値を中央に持ってくる
		swap(array, medianIndex, medianPosition);

		for (int i = start; i < medianIndex; i++) {
			if (array[i] > array[medianIndex]) {
				int rightIndex = findFirstSmallValue(Arrays.copyOfRange(array,
						medianIndex + 1, array.length), array[medianIndex]);
				if (rightIndex < 0) {
					throw new RuntimeException("右辺の配列に変換用の値が見つかりませんでした");
				}
				int toIndex = rightIndex + medianIndex + 1;
				swap(array, i, toIndex);
			}
		}

		medianSort(array, start, medianIndex - 1);
		medianSort(array, medianIndex + 1, end);

	}

	/**
	 * 配列内の第二引数より小さい最初の値を返す
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

	/**
	 * 配列内を指定された順番に並べ変えた時のn番目の値の配列内での位置を返す
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

		// FIXME Javaの標準APIのソート機能を使っているがここは中央値ソートの本筋ではないのでいったん許容
		// あとで、中央値を検索するロジックに書き直す
		List<Integer> sortedList = list.stream().sorted(comparator)
				.collect(Collectors.toList());

		int nthValue = sortedList.get(nth);

		return list.indexOf(nthValue);

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
