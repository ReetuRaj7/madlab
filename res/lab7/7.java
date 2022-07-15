import java.util.*;
 
public class RoundRobin_7a{
	public static void main(String [] args){
		int bt[],rt[],num,quantum,rp;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of operations");
		num = sc.nextInt();
		bt = new int[num];
		rt = new int[num];
		System.out.println("Enter the burst times");
		for(int i=0;i<num;i++){
			System.out.println("p["+(i+1)+"]"); 
			bt[i] = sc.nextInt();
			rt[i] = bt[i];
		}
 
		System.out.println("Enter the quantum");
		quantum = sc.nextInt();
 
		int i = 0;
		int time = 0;
		rp = num;
		System.out.println("|Process|Time|");
 
 
		while(rp > 0){
			if(rt[i] > quantum){
				time += quantum; 
				rt[i] -= quantum;
				System.out.print("|P"+(i+1)+"|");
				System.out.println(time);
			}else if(rt[i] <= quantum && rt[i] > 0){
				time += rt[i];
				rt[i] = 0;
				System.out.print("|P"+(i+1)+"|");
				System.out.println(time);
				rp--;
			}
			i = (i+1)%num;
		}
	}
 
}

P[1]: 4
P[2]: 5
P[3]: 8
P[4]: 2
Enter quantum: 4




/////////////////////////////////////////////////////////////////////////////////



  import java.util.*;
 
public class ShortestJobFirst{
	public static void main(String [] args){
		int bt[],wt[],total_wt,tat,num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of processes");
		num = sc.nextInt();
		bt = new int[num];
		int process[] = new int[num];
		for(int i=1;i<=num;i++)process[i-1] = i;
		for(int i=0;i<num;i++){
			System.out.print("P["+(i+1)+"] ");
			bt[i] = sc.nextInt();
		}
		wt = new int[num];
		wt[0] = 0;
		total_wt = 0;
		int temp,pos;
		for(int i=0;i<num;i++){
			pos = i;
			for(int j=i+1;j<num;j++){
				if(bt[j] < bt[pos])
					pos = j;
			}
			temp = bt[i];
			bt[i] = bt[pos];
			bt[pos] = temp;
 
			temp = process[i];
			process[i] = process[pos];
			process[pos] = temp;
		}
		for(int i=1;i<num;i++){
			wt[i] = wt[i-1] + bt[i-1];
			total_wt += wt[i];
		}
		float atwt = (float)total_wt/num;
 
		tat = 0;
		for(int i=0;i<num;i++){
			tat += (wt[i] + bt[i]);
		}
		float atot = (float)tat/num;
		System.out.println("Process\t Burst Time\t Wait Time\t"); 
		for(int i=0;i<num;i++){
			System.out.println("P["+process[i]+"]\t\t" + bt[i] +"\t\t" + wt[i]);
		}
		System.out.println("Average wait time is " + atwt );
		System.out.println("Average turnout time " + atot);
	}
}



Enter number of
process: 3
Enter Burst time:
Process[1]: 20
Process[2]: 30
Process[3]: 15

