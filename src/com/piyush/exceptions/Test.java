package com.piyush.exceptions;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

    public static void main(String args[]) throws Exception {

        //int[] arr = {3,2,1,5,4,6};
        //int [] arr = {1,3,4,2};
        int[] arr = {3,4,5,1,2};
        //int [] arr = {1,3,2};
        //int [] arr = {2,1,3};



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCases; i++) {
            int length = Integer.parseInt(br.readLine());
            String[] nodeString = br.readLine().split("\\s+");
            int[] nodes = new int[length];
            for(int j = 0; j < length; j++) {
                nodes[j] = Integer.parseInt(nodeString[j]);
            }

            boolean flag = findIfBST(nodes, 0, length - 1);
            if(flag) System.out.println("YES");
            if(!flag) System.out.println("NO");

        }

    }

    public static boolean findIfBST(int[] arr, int start, int end) {
        if(start >= end || end - start == 1) return true;
        int root = arr[start];
        int maxIndex = findFirstMaxIndex(arr, root, start+1, end);
        if(maxIndex != Integer.MIN_VALUE) {
            for(int i = maxIndex+1; i <= end; i++) {
                if(arr[i] < root) return false;
            }
        }
        boolean right = (maxIndex != Integer.MIN_VALUE) ? findIfBST(arr, maxIndex, end) : true;
        boolean left = (maxIndex != Integer.MIN_VALUE) ? findIfBST(arr, start+1, maxIndex-1) : findIfBST(arr, start + 1, end);

        return left && right;
    }

    public static int findFirstMaxIndex(int[] arr, int ref, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(arr[i] > ref) return i;
        }
        return Integer.MIN_VALUE;
    }
}



