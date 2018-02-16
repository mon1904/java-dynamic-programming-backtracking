

public class RodCuttingBottomUp {


	private static int rodLength = 5;  // Try changing this parameter. What happens with very long rods ?
	private static int prices[] = {0,1,5,5,2,1,2,17,20,24,30};
	private static int optimalPrices[] = new int[rodLength+1];	// new array for r (price) + 1 to avoid the 0 space in the array
	private static int cuts[] = new int[rodLength+1];	// new array for s (cut position)


	private static int rodCut(int length) {

		int bestPrice = -1;	// Tell it there is nothing in it
		optimalPrices[0]= 0;	// optimal value for rods of length 0....n - optimal price for 0 is 0.
		cuts[0]=0;

		for(int i=1; i<=length; i++)  { //iterate through the possible length (1, n-1) (2,n-2)
			for(int j=1; j<=i; j++) {	// find max cutting position for j
				if(bestPrice  < Math.max(bestPrice, prices[j] + optimalPrices[i-j])) {
					bestPrice = Math.max(bestPrice, prices[j] + optimalPrices[i-j]);

					cuts[i]=j;

				}		
			}
			System.out.println("we computed the optimal sol. of rod length :: " + i);
			optimalPrices[i]=bestPrice;
			printOptimalPricesArray(); 
		}
		return optimalPrices[length];

	}

	/**
	 * @param args
	 */

	public static void printOptimalPricesArray()
	{
		System.out.print("optimalPrices=[");
		for(int i=0; i <  optimalPrices.length; i++)
			System.out.print(optimalPrices[i] + ", ");
		System.out.println("]");
	}

	public static void main(String[] args) {


		printOptimalPricesArray(); 
		System.out.println("\nBEST PRICE=" + rodCut(rodLength) + " for a rod piece of length :: " + rodLength);

		int length = rodLength;
		System.out.println("\nPIECES CUTTED:");
		while (length > 0) {
			int item = cuts[length];
			System.out.println("Cutted a piece of length :: " + item + " and price= " + prices[item] );
			length -= item;
		}
	}
}
