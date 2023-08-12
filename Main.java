package binaryTree;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

//		int n = 10;
//		int newValue;
//		boolean has = true;
//		
//		int[] numbersUtilized = new int[n];
//		
//		Random rand = new Random();
//		
//		for (int i = 0; i < n; i++) {
//			newValue = rand.nextInt(20);
//			while (has == true) {
//				has = false;
//				for (int Number : numbersUtilized) {
//					if (newValue == Number) {
//						has = true;
//						break;
//					}
//				}
//			}
//			numbersUtilized[i] = newValue;
//			bt.insert(newValue);
//		}
		

		int[] list = {45, 10, 90, 7, 12, 50};
		
		for (int num: list){
			bt.insert(num);
		}

		bt.print();

		System.out.println("-----------");
		bt.delete(7);

		bt.print();
	}

}
