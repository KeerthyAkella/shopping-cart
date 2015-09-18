import java.util.ArrayList;


public class ShoppingCart {
	
	private ArrayList<Object> cart = new ArrayList<Object>();
	private float totalAmount;
	private double tax;
	private double discount;
	private double finalPrice;
	private boolean couponFlag;
	
	public void addToCart(Item i1) {
		cart.add(i1);
	}

	public void showCart() {
		Item temp=new Item(null,0,0);
		for(int i = 0; i < cart.size(); i++){
			temp = (Item) cart.get(i);
			//System.out.println(temp.itemName+" "+temp.quantity+" "+temp.price);
		}
	}

	public void removeFromCart(Item i3) {
		Item temp=new Item(null,0,0);
		for(int i = 0; i < cart.size(); i++){
			temp = (Item)cart.get(i);
			if((temp.itemName).equals(i3.itemName))
				cart.remove(i);
		}
			
	}

	public double getTotalAmount() {
		Item temp = new Item(null,0,0);
		totalAmount = 0;
		for(int i = 0; i < cart.size(); i++){
			temp = (Item)cart.get(i);
			totalAmount = totalAmount+(float) (temp.price * temp.quantity);
		}	
		return totalAmount;
	}

	public double getPayableAmount() {
		if(couponFlag==true)
			discount = totalAmount *(0.10);
		else
			discount = 0;
		finalPrice = totalAmount-discount+tax ;
		return finalPrice;
	}	
	
	 
	public double applyCoupon(String coupon) {
		if(coupon.equals("IND10") ){
			couponFlag = true;
				discount = totalAmount*(10/100);
			return discount;
		}
		couponFlag = false;
		return 0;
	}

	public void printInvoice() {
		Item temp=new Item(null,0,0);
		for (int i = 0; i < cart.size(); i++) {
			temp = (Item) cart.get(i);
			System.out.println(temp.itemName+" "+temp.quantity+" "+temp.price+" "+temp.price*temp.quantity);
		}
		getTotalAmount();  
		tax = Math.floor((totalAmount - discount)*(0.14));
		getPayableAmount();
		System.out.println("Total:"+ totalAmount);
        System.out.println("Tax:"  +  tax);
        System.out.println("Disc%:"+ discount);
        System.out.println("Total:" + finalPrice);
        System.out.println("");
	}

}
