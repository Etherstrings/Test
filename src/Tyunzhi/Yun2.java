package Tyunzhi;

import java.util.Scanner;

public class Yun2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] matrix=new int[n][m];
            for (int i=0;i<n ;i++ )
            {
                String str=sc.next();
                for (int j=0;j<m ;j++ )
                {
                    matrix[i][j]=str.charAt(j)-'0';
                }
            }

            int[][] sum=new int[n+1][m+1];
            for (int i=1;i<=n ;i++ )
            {
                for (int j=1;j<=m ;j++ )
                {
                    sum[i][j]=sum[i-1][j]+
                            sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
                }
            }
            int left=0,right=sum[n][m],res=0;
            while (left<=right)
            {
                int mid=(left+right)/2;

                if (judge(mid,n,m,sum))
                {
                    left=mid+1;
                    res=mid;
                }
                else
                {
                    right=mid-1;
                }
            }
            System.out.println(res);
        }
        sc.close();
    }


    public static int cal(int x,int y,int i,int j,int[][] sum)
    {
        return sum[x][y]-sum[x][j]-sum[i][y]+sum[i][j];
    }
    //判断x是否小于等于小于田地中最小一块的值
    public static boolean judge(int x,int n,int m,int[][] sum)
    {
        for (int i=1;i<=m-3 ;i++ )
        {
            for (int j=i+1;j<=m-2 ;j++ )
            {
                for (int k=j+1;k<=m-1 ;k++ )
                {
                    int last=0,cnt=0;
                    for (int r=1;r<=n ;r++ )
                    {
                        int s1=cal(r,i,last,0,sum);
                        int s2=cal(r,j,last,i,sum);
                        int s3=cal(r,k,last,j,sum);
                        int s4=cal(r,m,last,k,sum);
                        //当前横切一刀条件满足
                        if (s1>=x&&s2>=x&&s3>=x&&s4>=x)
                        {
                            last=r;
                            cnt++;
                        }
                    }
                    //表明x小于等于16块田地中的最小值，返回true
                    if (cnt>=4)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
