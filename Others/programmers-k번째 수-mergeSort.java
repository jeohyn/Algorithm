//programemrs K번째 수 problem
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length;i++){
            int s=commands[i][0]-1;
            int e=commands[i][1];
            int r=commands[i][2]-1;
            int[] res=Arrays.copyOfRange(array, s, e);
            mergeSort(0, res.length-1, res);
            answer[i]=res[r];
        }
        return answer;
    }

    public void mergeSort(int s, int e, int[] array){
        if(s<e){
            int m=(int)Math.floor((s+e)/2);
            mergeSort(s, m, array);
            mergeSort(m+1, e, array);
            merge(s, m, e, array);
        }
    }

    public void merge(int s, int m, int e, int[] array){
        int n1=m-s+1;
        int n2=e-m;
        int [] L=new int[n1];
        int [] R=new int[n2];

        for(int i=0;i<n1;i++){
            L[i]=array[s+i];
        }
        for(int j=0; j<n2;j++){
            R[j]=array[m+j+1];
        }

        int i=0;
        int j=0;
        int k=s;

        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                array[k]=L[i];
                i++;
            }
            else{
                array[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            array[k]=L[i];
            k++;
            i++;
        }
        while(j<n2){
            array[k]=R[j];
            k++;
            j++;
        }
    }

}
