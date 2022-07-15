import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int finish[]=new int[6];
		int alloc[][]=new int[6][4];
		int need[][]=new int[6][4];
		int maxi[][]=new int[6][4];
		int avail[]=new int[4];
		int cnt=5;
		for(int i=1;i<6;i++)
		finish[i]=0;
		Scanner s=new Scanner(System.in);
		System.out.println("Alloction");
		for(int i=1;i<6;i++)
		    for(int j=0;j<4;j++)
		        alloc[i][j]=s.nextInt();
		System.out.println("Max availabe");
		for(int i=1;i<6;i++)
		    for(int j=0;j<4;j++)
		        maxi[i][j]=s.nextInt();
		System.out.println("availability");
		    for(int j=0;j<4;j++)
		        avail[j]=s.nextInt();
		for(int i=1;i<6;i++)
		    for(int j=0;j<4;j++)
		        need[i][j]=maxi[i][j]-alloc[i][j];
		System.out.println("Need Resources");
		for(int i=1;i<6;i++){
		    for(int j=0;j<4;j++)
		        System.out.print(need[i][j] + " ");
		  System.out.println();
		}
		while(cnt>0)
		{
		    for(int i=1;i<6;i++)
		    {
		        boolean flag=true;`
		        if(finish[i]==0)
		        {
		            for(int j=0;j<4;j++)
		            {
		                if(need[i][j]>avail[j])
		                {
		                    flag=false;
		                    break;
		                }
		            }
		            if(flag==true)
		            {
		                for(int j=0;j<4;j++)
		                avail[j]+=alloc[i][j];
		              cnt--;
		              finish[i]=1;
		              System.out.println("Job done" +" "+i);
		            }
		        }
		    }
		}
		for(int j=0;j<4;j++)
		    System.out.println(avail[j]);
	}
}
