package test;

public class test2 {

	public static void main(String[] args) {
		
		int array []= {2,5,1,3,9};
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length-i-1;j++) {
				if(array[j]>array[j+1]) {  //n个数比较n-1次
					int temp=array[j+1]; 	//n-(m=i+1) =array.length-i-1
					array[j+1]=array[j];
					array[j]=temp;	
				}
			}
		}
		
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);	
		}
	}
}
