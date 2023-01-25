package com.avijeet.practice_2022.array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
//        int[] startArr=new int[100001];
//        int[] endArr=new int[100001];
//        for(int[] interval:intervals){
//            startArr[interval[0]]++;
//            endArr[interval[1]]--;
//        }
//        startArr[newInterval[0]]++;
//        endArr[newInterval[1]]--;
//        boolean isInterval=false;
//
//        int start=-1;
//        int end=-1;
//        // if(startArr[0]>0){
//        //     start=0;
//        //     isInterval=true;
//        // }
//        List<int[]> finalIntervals=new ArrayList();
//        for(int i=0;i<100001;i++){
//
//            if(i>0)startArr[i]+=startArr[i-1];
//
//            if(isInterval){
//                if(startArr[i]-endArr[i]==0){
//                    end=i;
//                    int[] interval=new int[2];
//                    interval[0]=start;
//                    interval[1]=end;
//                    finalIntervals.add(interval);
//                    isInterval=false;
//                }
//
//            }else{
//                if(startArr[i]>0){
//                    start=i;
//                    isInterval=true;
//                    if(startArr[i]-endArr[i]==0){
//                        end=i;
//                        int[] interval=new int[2];
//                        interval[0]=start;
//                        interval[1]=end;
//                        finalIntervals.add(interval);
//                        isInterval=false;
//                    }
//                }
//            }
//            if(i>0)startArr[i]+=endArr[i-1];
//        }
//
//        return finalIntervals.toArray(new int[finalIntervals.size()][2]);

        int n=intervals.length;
        if(n==0){
            int[][] result=new int[1][2];
            result[0]=newInterval;
            return result;
        }
        int lsb=intervals[0][0];
        int msb=intervals[n-1][1];
        int l=newInterval[0];
        int r=newInterval[1];
        if(r<lsb){
            int[][] result=new int[n+1][0];
            addArray(1,0,result, intervals, n);
            result[0]=newInterval;
            // System.out.println("case1");
            return result;
        }else if(l>msb){
            int[][] result=new int[n+1][0];
            addArray(0,0,result, intervals, n);
            result[n]=newInterval;
            // System.out.println("case2");
            return result;
        } else if(l<=lsb&&r>=msb){
            int[][] result=new int[1][2];
            result[0]=newInterval;
            // System.out.println("case3");
            return result;
        }

        double li=-1;
        double ri=(double)n-0.5;

        for(double i=0;i<n;i++){
            int[] a=intervals[(int)i];
            if(li==-1 && l<a[0]){
                li=i-.5;
            } else
            if(l<=a[1] && l>=a[0]){
                li=i;
            }
            if( ri==(double)n-0.5 && r<a[0]){
                ri=i-0.5;
            } else
            if(r>=a[0] && r<=a[1]){
                ri=i;
            }
        }
        if(li==ri){
            if(li%1.0==0){
                return intervals;
            }
            int[][] result=new int[n+1][2];
            addArray(0,0,result,intervals,(int)li+1);
            result[(int)li+1]=newInterval;
            addArray(1,(int)li+1,result,intervals,n);
            return result;
        }
        int size=n-(int)(ri-li);
        int t=0;
        if(li%1.0!=0.0 && ri%1.0!=0.0)
            t=1;
        int result[][]=new int[size+t][2];
        newInterval[0]=Math.min(intervals[(int)(li+0.5)][0],newInterval[0]);
        newInterval[1]=ri<=n-1?Math.max(intervals[(int)ri][1],newInterval[1]):newInterval[1];
        addArray(0,0,result,intervals,(int)(li+0.5));
        result[(int)(li+0.5)]=newInterval;
        addArray(t-(int)(ri-li),(int)ri+1,result,intervals,n);
        return result;
    }

    public static void main(String[] args) {
        int[][] arr=insert(new int[][]{
                {1,5},{9,12},{22,24}
        }, new int[]{7,14});
        for(int[] ar:arr){
            System.out.print(String.format("{%s, %s} ", ar[0], ar[1]));
        }
    }
    static void addArray(int i, int j, int result[][], int intervals[][], int n){
        for(;j<n;j++){
            result[j+i]=intervals[j];
        }
    }
}
