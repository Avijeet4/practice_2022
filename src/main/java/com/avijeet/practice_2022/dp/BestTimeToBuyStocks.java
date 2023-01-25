package com.avijeet.practice_2022.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BestTimeToBuyStocks {
    public static int maxProfit(int[] a) {
        int n=a.length,l=0;
        List<Purchase> purchases=new LinkedList<>();
        for(int i=1;i<n;i++){
            if(a[i-1]>a[i]){
                if(l<i-1 && a[l]<a[i-1])
                    purchases.add(new Purchase(a[l],a[i-1]));
                // res+=a[i]-a[l];
                l=i;
            }else if(i==n-1 && a[l]<a[i]){
                purchases.add(new Purchase(a[l],a[i]));
            }
        }
        int m=purchases.size();

        for (int i = 0; i < m - 1 && m > 2; i++) {
            System.out.println(purchases);
            Purchase p1 = purchases.get(i);
            Purchase p2 = purchases.get(i + 1);
            if ((p1.l <= p2.l && p1.r < p2.r)||(p1.l < p2.l && p1.r <= p2.r)) {
                purchases.remove(i);
                Purchase combo = purchases.get(i);
                combo.l = p1.l;
                m = purchases.size();
                i--;
            }
        }
//            break;
//        }
        System.out.println(purchases);
        int max1=0;
        int max2=0;
        for(Purchase p:purchases){
            if(p.r-p.l>=max2){
                max1=max2;
                max2=p.r-p.l;
            }else if(p.r-p.l>=max1){
                max1=p.r-p.l;
            }
        }

        return max1+max2;
    }

    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0,9}));
        System.out.println(maxProfit(new int[]{8,6,4,3,3,2,3,5,8,3,8,2,6}));
    }
//
}
class Purchase{
    int l,r;
    Purchase(int l, int r){
        this.l=l;
        this.r=r;
    }
    public String toString(){
        return String.format("Purchase:[%s, %s]", l,r);
    }
}