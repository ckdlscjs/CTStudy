package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class Problem263 {
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args)
            throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        arr.add(nums[0]);
        for (int i = 1; i < N; i++) {
            if(arr.get(arr.size()-1) < nums[i]) {
                arr.add(nums[i]);
            }else{
                int idx = lowerBound(arr, nums[i]);
                arr.set(idx, nums[i]);
            }
        }
        System.out.println(arr.size());
    }

    private static int lowerBound(ArrayList<Integer> arr, int num) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr.get(mid) >= num) {
                right = mid - 1;
            }else{ // arr[mid] >= num
                left = mid + 1;
            }
        }
        return left;
    }
}