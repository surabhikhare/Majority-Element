import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return  a[left];
        }
        if(left>right){
            return -1;
         }
        int mid=left+(right-left)/2;
        int x=getMajorityElement(a,left,mid);
        int y=getMajorityElement(a,mid+1 ,right);
         if(x==-1 && y!=-1){
                 int num=coun(a,left,right,y);
                  if(num>(right-left+1)/2){
                        return y;
                      }
                    else{
                        return -1;
                      }
                 }
           else if(x!=-1 && y==-1){
                 int num=coun(a,left,right,x);
                 if(num>(right-left+1)/2){
                      return x;}
                  else{
                         return -1;
                      }
                }
             else if(x!=-1 && y!=-1){
               int lefnum=coun(a,left,right,x);
               int rignum=coun(a,left,right,y);
                 if(lefnum>(right-left +1)/2){
                          return x;}
                  else if(rignum>(right-left+1)/2){
                          return y;}
                   else{
                              return -1;}
           }
            else{
               return -1;}           
    }
  public static int coun (int[] a, int left, int right, int element){
        int count=0;
         for(int i=left;i<=right;i++){
              if(a[i]==element){
                  count++;
                   }
               }return count;
     }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
         int ab=getMajorityElement(a,0,a.length-1);
        // System.out.println(ab);
        if (ab!= -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

