package test;

public class Choose {

	public static void main(String[] args) {
		int array[]= {1,6,3,7,9};
		for(int i=0;i<array.length;i++) {  //比较趟数
			int index=0; //每一趟比较中最大值的索引
			for(int j=i;j<array.length-1;j++) {   //每一趟比较的次数
				if(array[j]>array[index]) { //array.length-1最后一个不要比较
					index=j;
				}
			}
			int temp=array[i];
			array[i]=array[index];
			array[index]=temp;
		}
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
}
