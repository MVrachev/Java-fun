package bg.uni.sofia.fmi.mjt.shopping;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class ListShoppingCart implements ShoppingCart {
	
	public class Pair implements Comparable<Pair>{
		
		private Item item;
		private int numItems;
		
		Pair(Item item, int numItems){
			this.item = item;
			this.numItems = numItems;
		}
		
		public Item getItem() {
			return item;
		}
		public void setItem(Item item) {
			this.item = item;
		}
		public int getNumItems() {
			return numItems;
		}
		public void setNumItems(int numItems) {
			this.numItems = numItems;
		}
		
		public int compareTo(Pair other) {
	       if(this.numItems > other.numItems)
	       {
	    	   return 1;
	       }
	       else if (this.numItems < other.numItems)
	       {
	    	   return -1;
	       }
			return 0;
	    }
	}
	
	private List<Pair> cart;
	
	
	public ListShoppingCart(List<Pair> cart){
		this.cart = cart;
		
	}
	
	public Collection<Item> getUniqueItems(){
		List<Item> result = new ArrayList<Item>();
		
		for(Pair pair: cart){
			if(!cart.contains(pair)) {
				result.add(pair.getItem());
			}
		}
		return result;
	}
	

	public Collection<Item> getSortedItems(){
		
		Collections.sort(cart);
		List<Item> result = new ArrayList<Item>();
		for(Pair pair: cart){
			result.add(pair.getItem());
		}
		return result;
		
		
	}
	
	public void addItem(Item item) {
		
		for(Pair pair: cart) {
			if(cart.contains(pair)) {
				pair.setNumItems(pair.getNumItems() + 1);
				return;
			}
		}
		
		Pair newPair = new Pair(item, 0);
		cart.add(newPair);
	}
	
	 public void removeItem(Item item) throws ItemNotFoundException{
		 
	 }

	 
	public double getTotal() {
		double result = 0;
		for(Item item: cart) {
			result+=item.getPrice();
		}
		return result;
	}
	
}
