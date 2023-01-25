package com.avijeet.practice_2022.binaryTree;

import java.util.Stack;

public class VerifyPreorderSerialization {
    public static boolean isValidSerialization(String preorder) {
        int n=preorder.length();
        if(n==0 || (n==1 && preorder.equals("#"))){
            return true;
        }
        String arr[]=preorder.split(",");
        Stack<String> s=new Stack();

        s.push(arr[0]);
        int i=1;
        while(!s.isEmpty()){
            if(s.peek().equals("#")){
                s.pop();
                if(!s.isEmpty() && s.peek().equals("#")) {
                    s.pop();
                    if(!s.isEmpty())
                        s.pop();
                    s.push("#");
                    continue;
                }else{
                    s.push("#");
                }
            }
            if(i==arr.length)
                break;
            String c=arr[i];
            s.push(c);
            i++;
        }
        return s.size()==1 && s.peek()=="#";
    }
    public static boolean isValidSerialization2(String preorder) {
        int n=preorder.length();
        if(n==0 || (n==1 && preorder.equals("#"))){
            return true;
        }

        int i=0;
        int level=1;
        while(i<n){
            char c=preorder.charAt(i);
            if(c=='#'){
                level--;
                i+=2;
                if(i>=n){
                    i=n;
                    break;
                }
            }else{
                level++;
                int x = preorder.indexOf(",",i+1);
                if(x!=-1){
                    i=x+1;
                }else{
                    i=n;
                }
            }

        }
        return i==n && level==0;
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization2("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
