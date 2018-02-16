
public class RodCutting {


		private static int rodLength = 5;  // Try changing this parameter. What happens with very long rods ?
		private static int prices[] = {1,5,8,9,10,17,17,20,24,30};
		private static int cuts[] = new int[rodLength ];
		private static int optimalPrices[] = new int[rodLength ];
		
		private static int rodCut(int length) {
				 
			
			if(optimalPrices[length-1] != 0) {
				System.out.println("we extract from the array the optimal sol. of rod length :: " + length);
				return optimalPrices[length-1]; // Note that we avoid computing this rodCut because  
			}                                 // the result was previously stored in the array
			
	
			int bestPrice = prices[length - 1];
			cuts[length - 1] = length;
			
			if(length == 1) {      // Base case: only a piece of length 1 is left for cutting, then, no need of cutting
				System.out.println("we return price for the item of leght 1 (base case) ") ;
				return prices[0];
			}
			
					
			for(int i=1; i <  length ; i++) {  // i iterates over all the possible lengths
				int firstCutPrice = prices[i-1];
				int leftOverRodPrice = rodCut(length - i);
				int totalPrice = firstCutPrice + leftOverRodPrice;
				if(totalPrice > bestPrice) {
					bestPrice = totalPrice;
					cuts[length - 1] = i;  // We store the best piece-length (i) for a rod of length=length 
				}
			}
			
			System.out.println("we computed the optimal sol. of rod length :: " + length);
			optimalPrices[length-1] = bestPrice;
			printOptimalPricesArray(); 
			
			return bestPrice;
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
				int item = cuts[length - 1];
				System.out.println("Cutted a piece of length :: " + item + " and price= " + prices[item-1] );
				length -= item;
			}
		}
	}
