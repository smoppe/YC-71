package test;

public class MaoPao {
	
public static void main(String[] args) {

	int [] array= {2,3,5,7,8};
	//ð������  ��һ�������ս������������ 
	for(int i=0;i<array.length;i++) {
		//��������
		for(int j=0;j<array.length-i-1;j++){ //����ÿ�αȽ�
			if(array[j]<array[j+1]) {
				int temp=array[j+1]; //temp���м�����
				array[j+1]=array[j];
				array[j]=temp;
			}
		}
	}
	//��֤ð������Ľ��
	for(int i=0;i<array.length;i++) {
		System.out.println(array[i]);
	}
}

}
