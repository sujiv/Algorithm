package sortroutines;

import java.util.Arrays;
import runtime.Sorter;

public class BSTSort extends Sorter {
	
	public static void main(String[] args) {
		BSTSort bst = new BSTSort();
		System.out.println(Arrays.toString(bst.sort(new int[] {0,2,1,5,3,7,9,8})));
	}

	@Override
	public int[] sort(int[] arr) {
		MyBST myBST = new MyBST();
		for(int x:arr) {
			myBST.insert(x);
		}
		
		return  myBST.printTr();
	}
}
