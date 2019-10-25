package test;

public class MaoPao {
	
public static void main(String[] args) {

	int [] array= {2,3,5,7,8};
	//冒泡排序  把一组数按照降序或者升序来 
	for(int i=0;i<array.length;i++) {
		//控制趟数
		for(int j=0;j<array.length-i-1;j++){ //控制每次比较
			if(array[j]<array[j+1]) {
				int temp=array[j+1]; //temp是中间容器
				array[j+1]=array[j];
				array[j]=temp;
			}
		}
	}
	//验证冒泡排序的结果
	for(int i=0;i<array.length;i++) {
		System.out.println(array[i]);
	}
}

}
