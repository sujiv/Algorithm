import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(secondSmallest(new int[]{9}));//GCD(7,9)
//		subSetSum2(new int[] {1,2,3,4,5}, 0);
//		System.out.print(Arrays.toString(reverse(new int[] {1, 2, 4, 3, 5})));//sort012(new int[] {0,2,2,1,1,0,2,1,0})));
//		System.out.println(subsetSum(new ArrayList<>(Arrays.asList(1,4,2,3,7,8,9)),19));
//		System.out.println(Arrays.toString(subsetSum(new int[] {1,4,2,3,7,8,9},29)));
//		System.out.println(check(new int[] {-8,-5,-1,0,2,5,6},0));
//		System.out.println(check(new int[] {-2,-1,0,1,4,6,7,8,9,12},0));
//		System.out.println(check(new int[] {0,2,4,6,7,8,9,12},0));
//		System.out.println(Arrays.toString(alterSort(new int[]{1, 2, 17, -4, -6, 8})));
//		System.out.println(countOne(new int[] {1, 2, 4, 9, 3, 2, 1, 4, 5}));
//		System.out.println(reverseWord("we test coders"));
		System.out.println(isPrime(111));
	}
	public static boolean isPrime(int n) {
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static String reverseWord(String s) {
		String sRet = "";
		List<Stack<Character>> stkList = new ArrayList<>();
		int i=0;
		stkList.add(new Stack<Character>());
		for(Character c:s.toCharArray()) {
			if(c==' ') {
				i++;
				continue;
			}
			if(stkList.size()<i+1)
				stkList.add(new Stack<Character>());
			
			stkList.get(i).push(c);
		}
		i=0;
		for(Stack<Character> stk:stkList) {
			while(!stk.isEmpty()) {
				sRet = sRet+stk.pop();
				StringBuilder sb = new StringBuilder();
				sb.append(stk.toArray());
				//System.out.println(i++);
			}
			sRet = sRet+" ";
		}
		return sRet.substring(0,sRet.length()-1);
	}
	public static int countOne(int[] s) {
		int[] cnt = new int[3*s.length-1];
		for(int i=0;i<s.length;i++) {
			cnt[s[i]]++;
		}
		for(int j=0;j<s.length;j++) {
			if(cnt[s[j]]==1)
				return s[j];
		}
		return 0;
	}
	public static int[] alterSort(int[] a) {
		int dir = 1;
		int[] ans = new int[a.length];
		for(int i=0;i<a.length;i++) {
			dir=0-dir;
			int tmp = 0;
			for(int j=0;j<a.length-i;j++) {
				if(a[tmp]*dir<a[j]*dir) {
					tmp=j;
				}
			}
			ans[i]=a[tmp];
			a[tmp]=a[a.length-1-i];
		}
		return ans;
	}
	
	public static Integer check(int[] A, int lower) {
		int m = A.length/2;
		if(A.length==0)
			return null;
		else if(A[m]==m+lower)
			return A[m];
		else if(A[m]<m+lower)
			return check(Arrays.copyOfRange(A, m, A.length),m+lower);
		else
			return check(Arrays.copyOf(A, m),lower);
	}
	
	public static List<Integer> subsetSum(List<Integer> a, int sum) {
		if(sum==0)
			return new ArrayList<Integer>();
		else{
			for(int i=0;i<a.size();i++) {
				List<Integer> param = new ArrayList<>();
				param.addAll(a);
				Integer p = param.remove(i);
				List<Integer> ans = subsetSum(param,sum-p);
				if(ans!=null) {
					ans.add(0, p);
					return ans;
				}
			}
			return null;			
		}
	}
	
	public static int[] subsetSum(int[] a, int sum) {
		if(sum==0)
			return new int[0];
		else{
			for(int i=0;i<a.length;i++) {
				int[] param = new int[a.length-1];
				System.arraycopy(a, 0, param, 0, i);
				System.arraycopy(a, i+1, param, i, a.length-i-1);
				Integer p = a[i];
				param = subsetSum(param,sum-p);
				if(param!=null) {
					int[] ans = new int[param.length+1];
					System.arraycopy(param, 0, ans, 1, param.length);
					ans[0] = p;
					return ans;
				}
			}
			return null;			
		}
	}
	
	private static int[] reverse(int[] arr) {
		if(arr.length>1) {
			int[] a = reverse(Arrays.copyOfRange(arr, 0, arr.length/2));
			int[] b = reverse(Arrays.copyOfRange(arr, arr.length/2, arr.length));
			arr = combine(b,a);
		}
		return arr;
	}
	
	private static int[] combine(int[] x, int[] y) {
		int[] z = new int[x.length+y.length];
		int c = 0;
		for(int i:x) {
			z[c++] = i;
		}
		for(int j:y) {
			z[c++]=j;
		}
		return z;
	}
	
	public static int GCD(int m, int n) {
		return (n==0)?m:GCD(n, m%n);
	}
	
	public static int secondSmallest(int[] arr) { 
		if(arr==null || arr.length < 2) { 
			throw new IllegalArgumentException("Input array too small"); 
		}
		
		int firstSmallest = arr[0];
		int secondSmallest= arr[1];
		
		for(int i=1;i<arr.length;i++) {
			if(firstSmallest>arr[i]) {
				secondSmallest = firstSmallest;
				firstSmallest = arr[i];
			}
			if(secondSmallest>arr[i]&&arr[i]>firstSmallest) {
				secondSmallest = arr[i];
			}
		}
		return secondSmallest;
	} 
	
	public static int[] subSetSum(int[] arr, int sum) {
		if(sum==0)
			return (new int[0]);
		int[] arrtmp = arr;
		int[] result = new int[arr.length];
		for(int k=0;k<arr.length;k++) {
			System.out.println(arr[k]+"="+arr[k]);
			if(arr[k]==sum) {
				System.out.println("SubsetSum:["+arr[k]+"]");
				return new int[] {arr[k]};
			}
			for(int i=0;(i<arr.length-1)&&(i<arr.length-k);i++) {
				int sum2=arrtmp[i];
				String s=""+arrtmp[i];
				result = new int[arr.length];
				result[0]=arrtmp[i];
				for(int j=i+1;j<arr.length-k;j++) {
					sum2+=arrtmp[j];
					result[j-i]=arrtmp[j];
					s = s+"+"+arrtmp[j];
					if(sum2==sum) {
						//return result;
						return Arrays.copyOf(result, j-i+1);
					}
					System.out.println(s+"="+sum2);
				}
				//System.out.println("swap loop 1 end-----"+"i:"+i+" k:"+k);
				if(i<arrtmp.length-1) {
					int tmp=arrtmp[i];
					arrtmp[i]=arrtmp[i+1];
					arrtmp[i+1]=tmp;
				}
			}
			//System.out.println("=========loop2 end==========");
		}
		return new int[2];
	}

	public static int[] subSetSum2(int[] arr, int sum) {
		if(sum==0)
			return new int[0];
		long size = (long) Math.pow(2, arr.length);
		int[] arr2=new int[arr.length];
		for(int i=0;i<size;i++) {
			int sum2=0;
			String array="";
			int count = 0;
			for(int j=0;j<arr.length;j++) {
				if((i&(1<<j))>0) {
					sum2+=arr[j];
					array=array+"+"+arr[j];
					arr2[count] = arr[j];
					count++;
					if(sum2==sum) {
						array=array.substring(1);
						System.out.println(array+"="+sum);
						int[] ans = new int[count];
						for(int k=0;k<count;k++) {
							ans[k] = arr2[k];
						}
						return ans;
					}
				}
			}
		}
		return null;
	}
	
	public static int[] sort012(int[] A) {
		int ind0 = 0;
		int ind1 = 0;
		int temp = 0;
		for(int i=0;i<A.length;i++) {
			if(A[i]==0) {
				temp = A[ind0];
				A[ind0] = A[i];
				A[i] = A[ind0+ind1];
				A[ind0+ind1] = temp;
				ind0++;
			}
			else if(A[i]==1) {
				temp = A[ind0+ind1];
				A[ind0+ind1]=A[i];
				A[i] = temp;
				ind1++;
			}
			System.out.println("Iteration "+(i+1)+":\t"+Arrays.toString(A));
		}
		return A;
	}

}
