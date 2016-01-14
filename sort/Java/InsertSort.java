/**
 * ‘}“üƒ\[ƒg‚ğ‚·
 * @author masao
 *
 */
public class InsertSort {
	
	public static void main(String[] args) {
		
		int[] array = createRandomArray(Integer.parseInt(args[0]));
		
		System.out.println("®—ñ‘O");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		insertSort(array);
	}

	private static void insertSort(int[] array) {
		//TODO ƒAƒ‹ƒSƒŠƒYƒ€À‘•
	}

	/**
	 * intŒ^‚Ì”z—ñ‚É—”‚ğŠi”[‚·‚é
	 * @param num
	 * @return
	 */
	private static int[] createRandomArray(int num) {
		
		int[] result = new int[num];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random()*10);
		}
		
		return result;
	}

}
