package test;

import java.util.Scanner;
import java.util.Arrays;
 
public class spf {
	// 接口Comparable和类方法Arrays.sort()的配合使用可以使进程按arriveTime(到达时间)排序
    private static class PCB implements Comparable<PCB> {
	    String name;  //进程名
		float arriveTime; //到达时间
		float runTime; //需要运行时间
		float startTime;  //进程开始执行时间
		float finishTime; //进程完成时间
		char state;  
		
		//根据到达时间先后进行排序
		public int compareTo( PCB b ) {
			if( arriveTime==b.arriveTime ) return 0;
			if( arriveTime<b.arriveTime ) return -1;
			return 1;
		}
	}
	private static final float INF = 10000000.0f;
	/* 两种情况：
       1.在lastTime时刻，选择已经到达且拥有最短运行时间的进程
       2.在lastTime时刻，没有进程到达，此时选择拥有最早到达时间的进程
    */
	private static int findNext( PCB[] arr, float lastTime ) {
	    int i, p = -1;
		float minrunTime = INF;
		for( i = 0; i < arr.length; i++ ) {
		    if( arr[i].state=='R' ) {
			    /* 数组arr已经按arriveTime排序,当出现
			       arr[i].arriveTime>lastTime时,说明在lastTime时刻无进程到达,终止循环.*/
			    if( arr[i].arriveTime > lastTime ) break;  //还没有到达
			    
				if( arr[i].runTime < minrunTime )  //已经到达了，找运行时间最小的
				  { p = i; minrunTime = arr[i].runTime; }
			}
		}
		if( p != -1 ) return p;
		return i;  
	}
	
    public static void main( String[] args ) {
	    Scanner sc = new Scanner( System.in );
		System.out.print( "请输入进程个数:" );
		int num = sc.nextInt();
		PCB[] arr = new PCB[num];
		System.out.println( "请依次输入进程名,进程到达时间,进程运行时间:" );
		for( int i = 0; i < num; i++ ) {
		    arr[i] = new PCB();
			arr[i].name = sc.next();
			arr[i].arriveTime = sc.nextFloat();
			arr[i].runTime = sc.nextFloat();
			arr[i].state = 'R';  
		}
		Arrays.sort(arr); // 使进程按arriveTime(到达时间)排序,找第一个到达的
		
		float lastTime=arr[0].arriveTime;  //最先到达进程的到达时间
		for( int i=0; i<num; i++ ) {
		    // 找到下一个将要执行的进程
		    int p = findNext( arr, lastTime );
			if( arr[p].arriveTime<lastTime ) arr[p].startTime = lastTime;  
			else arr[p].startTime = arr[p].arriveTime;
			arr[p].finishTime = arr[p].startTime + arr[p].runTime;
			arr[p].state = 'F';  //已经完成
			
			lastTime = arr[p].finishTime;  // 更新lastTime，上一个进程完成时间
		}
		
		float sum1=0.0f, sum2=0.0f;
		System.out.println( "\n进程         到达时间       运行时间      开始时间     完成时间     周转时间     带权周转时间" );
		for( PCB jcb : arr ) {
			System.out.format( "%4s  %8.2f  %8.2f  ", jcb.name, jcb.arriveTime, jcb.runTime );
		    System.out.format( "%8.2f  %8.2f  ", jcb.startTime, jcb.finishTime );
			System.out.format( "%8.2f  ", jcb.finishTime-jcb.arriveTime );
			System.out.format( "%12.2f\n", (jcb.finishTime-jcb.arriveTime)/jcb.runTime );
			sum1 += jcb.finishTime-jcb.arriveTime;
			sum2 += (jcb.finishTime-jcb.arriveTime)/jcb.runTime;
		}
		System.out.format( "平均周转时间: %.3f\n", (sum1/num) );
		System.out.format( "平均带权周转时间: %.3f", (sum2/num) );
	}
}

