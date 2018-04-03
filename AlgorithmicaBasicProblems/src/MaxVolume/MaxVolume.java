/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that
 *  the two end points of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
 *   such that the container contains the most water.
 *   Note: You may not slant the container and n is at least 2. 
 *   
 *   *******LeetCode: Problem : 11 *********
 *   
*/
package MaxVolume;

public class MaxVolume {
	
	
	// TC = O(n^2);
	// Time limit exceeded in LeetCode
	public static int maxArea1(int[] in){
		int maxArea = Integer.MIN_VALUE,area;
		for(int i=0;i<in.length;++i){
			for(int j=i+1;j<in.length;++j){
				area = Math.min(in[i], in[j])* (j-i);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}
	
	public static int maxArea2(int[] in){
		int maxArea = Integer.MIN_VALUE,area;
		int i = 0, j = in.length-1;
		while(i<j){
			area=  Math.min(in[i], in[j]) * (j-i);
			maxArea = Math.max(maxArea, area);
			if(in[i]>in[j]) --j;
			else if(in[i]<in[j]) ++i;
			else ++i;
		}
		return maxArea;
	}

}
