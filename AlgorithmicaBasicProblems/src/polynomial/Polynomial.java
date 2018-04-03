/*
 *   Given a real number x, and a sequence of real numbers c0, c1, …cn,
 *   Write an efficient function to find out the value of following polynomial
 *   of degree ‘n’:
 *   pn(x) = cnxn + c n-1xn-1 + … + c2x2 + c1x + c0
 *   Function Prototype:
 *   double EvalPolynom(int[ ] coef, int x, int n)
 * */

package polynomial;

public class Polynomial {

	public static double evalPolynom(int[] coef, int x, int n) {
		if (coef == null || coef.length == 0 || coef.length < n + 1)
			return -1;

		int k = 0;
		double sum = 0;
		while (k <= n) {
			sum = sum + Math.pow(x, k) * coef[k];
			++k;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] coef = {0,1,2,3};
		int x = 2;
		int n = 3;
		System.out.println(evalPolynom(coef,x,n));
	}

}
