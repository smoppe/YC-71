package test;

public class ee {

	public static void main(String[] args) {
			int []array= {2,7,9,3,5};
		
			for(int i=0;i<array.length;i++) {  //�Ƚ�����
				int index=i; //ÿһ�˱Ƚ������ֵ������
				for(int j=i+1;j<array.length;j++) {   //ÿһ�˱ȽϵĴ���
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
