package test;

public abstract class Test3 {

	public static void main(String[] args) {
		int []array= {2,7,9,3,5};
		
		for(int i=0;i<array.length;i++) {
			int index=0;
			for(int j=i;j<array.length-1;j++) {
				if(array[j]>array[index]) {
					index=j;
				}
			}
			/*int max=array[index];
			array[index]=array[i];
			array[i]=max;*/
			int temp=array[i];
			array[i]=array[index];
			array[index]=temp;
			System.out.print("arry[0]:"+array[0]+"  ");
		}
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
}
