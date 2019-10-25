package test;

import java.util.Scanner;
import java.util.Arrays;
 
public class spf {
	// �ӿ�Comparable���෽��Arrays.sort()�����ʹ�ÿ���ʹ���̰�arriveTime(����ʱ��)����
    private static class PCB implements Comparable<PCB> {
	    String name;  //������
		float arriveTime; //����ʱ��
		float runTime; //��Ҫ����ʱ��
		float startTime;  //���̿�ʼִ��ʱ��
		float finishTime; //�������ʱ��
		char state;  
		
		//���ݵ���ʱ���Ⱥ��������
		public int compareTo( PCB b ) {
			if( arriveTime==b.arriveTime ) return 0;
			if( arriveTime<b.arriveTime ) return -1;
			return 1;
		}
	}
	private static final float INF = 10000000.0f;
	/* ���������
       1.��lastTimeʱ�̣�ѡ���Ѿ�������ӵ���������ʱ��Ľ���
       2.��lastTimeʱ�̣�û�н��̵����ʱѡ��ӵ�����絽��ʱ��Ľ���
    */
	private static int findNext( PCB[] arr, float lastTime ) {
	    int i, p = -1;
		float minrunTime = INF;
		for( i = 0; i < arr.length; i++ ) {
		    if( arr[i].state=='R' ) {
			    /* ����arr�Ѿ���arriveTime����,������
			       arr[i].arriveTime>lastTimeʱ,˵����lastTimeʱ���޽��̵���,��ֹѭ��.*/
			    if( arr[i].arriveTime > lastTime ) break;  //��û�е���
			    
				if( arr[i].runTime < minrunTime )  //�Ѿ������ˣ�������ʱ����С��
				  { p = i; minrunTime = arr[i].runTime; }
			}
		}
		if( p != -1 ) return p;
		return i;  
	}
	
    public static void main( String[] args ) {
	    Scanner sc = new Scanner( System.in );
		System.out.print( "��������̸���:" );
		int num = sc.nextInt();
		PCB[] arr = new PCB[num];
		System.out.println( "���������������,���̵���ʱ��,��������ʱ��:" );
		for( int i = 0; i < num; i++ ) {
		    arr[i] = new PCB();
			arr[i].name = sc.next();
			arr[i].arriveTime = sc.nextFloat();
			arr[i].runTime = sc.nextFloat();
			arr[i].state = 'R';  
		}
		Arrays.sort(arr); // ʹ���̰�arriveTime(����ʱ��)����,�ҵ�һ�������
		
		float lastTime=arr[0].arriveTime;  //���ȵ�����̵ĵ���ʱ��
		for( int i=0; i<num; i++ ) {
		    // �ҵ���һ����Ҫִ�еĽ���
		    int p = findNext( arr, lastTime );
			if( arr[p].arriveTime<lastTime ) arr[p].startTime = lastTime;  
			else arr[p].startTime = arr[p].arriveTime;
			arr[p].finishTime = arr[p].startTime + arr[p].runTime;
			arr[p].state = 'F';  //�Ѿ����
			
			lastTime = arr[p].finishTime;  // ����lastTime����һ���������ʱ��
		}
		
		float sum1=0.0f, sum2=0.0f;
		System.out.println( "\n����         ����ʱ��       ����ʱ��      ��ʼʱ��     ���ʱ��     ��תʱ��     ��Ȩ��תʱ��" );
		for( PCB jcb : arr ) {
			System.out.format( "%4s  %8.2f  %8.2f  ", jcb.name, jcb.arriveTime, jcb.runTime );
		    System.out.format( "%8.2f  %8.2f  ", jcb.startTime, jcb.finishTime );
			System.out.format( "%8.2f  ", jcb.finishTime-jcb.arriveTime );
			System.out.format( "%12.2f\n", (jcb.finishTime-jcb.arriveTime)/jcb.runTime );
			sum1 += jcb.finishTime-jcb.arriveTime;
			sum2 += (jcb.finishTime-jcb.arriveTime)/jcb.runTime;
		}
		System.out.format( "ƽ����תʱ��: %.3f\n", (sum1/num) );
		System.out.format( "ƽ����Ȩ��תʱ��: %.3f", (sum2/num) );
	}
}

