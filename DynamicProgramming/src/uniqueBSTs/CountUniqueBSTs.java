package uniqueBSTs;

public class CountUniqueBSTs {
	
	public int countUniqueBSTs(int n){
		if(n<=0) return 0;
		
		int[] mem = new int[n+1];
		mem[0] = mem[1] = 1;
		
		for(int i = 2; i<=n; ++i){
			for(int j = 0;j<i;++j){
				mem[i] = mem[i] + mem[j] * mem[i-j-1];
			}
		}
		return mem[n];
	}
	
	public static void main(String[] args) {
		CountUniqueBSTs unique = new CountUniqueBSTs();
		System.out.println(unique.countUniqueBSTs(4));
	}
}
