package test;

public class Choose {

	public static void main(String[] args) {
		int array[]= {1,6,3,7,9};
		for(int i=0;i<array.length;i++) {  //�Ƚ�����
			int index=0; //ÿһ�˱Ƚ������ֵ������
			for(int j=i;j<array.length-1;j++) {   //ÿһ�˱ȽϵĴ���
				if(array[j]>array[index]) { //array.length-1���һ����Ҫ�Ƚ�
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
