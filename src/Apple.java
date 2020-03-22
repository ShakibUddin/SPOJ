import java.util.Scanner;
class Apple{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=0;i<test;++i){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] price=new int[k+1];
            for(int j=1;j<=k;++j){
                price[j]=sc.nextInt();
            }
            if(getResult(price,n,k,k)>=1000000000 || getResult(price,n,k,k)<0){
                System.out.println(-1+"\n");
            }
            else{
                System.out.println(getResult(price,n,k,k)+"\n");
            }

        }
    }
    public static int getResult(int[] price,int n,int k,int index) {
        if(k==0)return 0;
        if(index<=0 || n<=0)return 1000000000;
        if(index<=k && price[index]!=-1){
            return Math.min(price[index]+getResult(price,n-1,k-index,index),getResult(price,n,k,index-1));
        }
        else{
            return getResult(price,n,k,index-1);
        }
    }
}