package test;

public class ee {

	public static void main(String[] args) {
			int []array= {2,7,9,3,5};
		
			for(int i=0;i<array.length;i++) {  //比较趟数
				int index=i; //每一趟比较中最大值的索引
				for(int j=i+1;j<array.length;j++) {   //每一趟比较的次数
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
