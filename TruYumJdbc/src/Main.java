import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	
	
	public static void main(String args[])throws Exception
	{
		
		MenuItemDaoImpl p = new MenuItemDaoImpl();
		
		
		//Filling Data Into DB 
		int n;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of Items");
		n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
		System.out.println("Enter Item Details Id,name,Cost,Category,Launchdate,AvailableStatus,DeliveryStatus");
		
		MenuItem kl = new MenuItem();
		kl.setId(Long.parseLong(sc.nextLine()));
		kl.setItemname(sc.nextLine());
		kl.setCost(Integer.parseInt(sc.nextLine()));
		kl.setItemcat(sc.nextLine());
		String lastCrawlDate = sc.nextLine();
		Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		kl.setLaunchdate(sqlDate);
		kl.setAvastatus(sc.nextLine());
		kl.setItemdeliverystatus(sc.nextLine());
		
		p.filldatabase(kl);
		}
	
		
		//Menu View For Admin
		List<MenuItem> l= null;
		l=p.getMenuItemListAdmin();
		int c=0;
		for(int i=0;i<l.size();i++)
		{
			if(c==0)
			{
				System.out.println("                             ADMIN     VIEW                                                  ");	
			System.out.println("ItemId  ItemName ItemCost  ItemCategory  ItemLaunchDate  ItemAvailableStatus  ItemdeliveryStatus");
			}
			c=1;
			System.out.println(l.get(i).getId()+"  "+l.get(i).getItemname()+"  "+l.get(i).getCost()+" "+l.get(i).getItemcat()+"  "+l.get(i).getLaunchdate()+"  "+l.get(i).getAvastatus()+" "+l.get(i).getItemdeliverystatus());
		}
		c=0;
		
		//Menu View For Customer
		List<MenuItem> m=null;
		m=p.getMenuItemListCustomer();
		for(int i=0;i<m.size();i++)
		{
			if(c==0)
			{
			System.out.println("                             CUSTOMER     VIEW                                                  ");	
			System.out.println("ItemId  ItemName ItemCost  ItemCategory  ItemLaunchDate  ItemAvailableStatus  ItemdeliveryStatus");
			}
			c=1;
			System.out.println(m.get(i).getId()+"  "+m.get(i).getItemname()+"  "+m.get(i).getCost()+" "+m.get(i).getItemcat()+"  "+m.get(i).getLaunchdate()+"  "+m.get(i).getAvastatus()+" "+m.get(i).getItemdeliverystatus());
		}
		
		//Retrieving Menu Item By Id
		MenuItem ok=p.getMenuItem(3);
		System.out.println("                                  YOUR ITEM DETAILS                                                  ");
		System.out.println(ok.getId()+" "+ok.getItemname()+" "+ok.getCost()+" "+ok.getItemcat()+" "+ok.getLaunchdate()+" "+ok.getAvastatus()+" "+ok.getItemdeliverystatus());
		
		//Editing Menu Item By Id
		long id=3;
		MenuItem obj= new MenuItem();
		obj.setId(id);
		obj.setItemname("FrenchFries");
		obj.setCost(70);
		obj.setItemcat("Snack");
		String ldate = "2019-09-08";
		Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(ldate);
		java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
		obj.setLaunchdate(sqldate);
		obj.setAvastatus("yes");
		obj.setItemdeliverystatus("yes");
		p.editMenuItem(obj);
		
		
		
		
		//Adding Items to Cart
		CartDaoImpl ne = new CartDaoImpl();
		//ne.addCartItem(1, 2);
		//ne.addCartItem(2, 3);
		
		
		
		
		//View Cart Items By Userid 
		long u=1;
		List<MenuItem> h=null;
		h=ne.getAllcartItems(u);
		c=0;
		for(int i=0;i<h.size();i++)
		{
			if(c==0)
			{
			System.out.println("                             CART     VIEW                                                  ");	
			System.out.println("ItemId  ItemName ItemCost  ItemCategory  ItemLaunchDate  ItemAvailableStatus  ItemdeliveryStatus");
			}
			c=1;
			System.out.println(h.get(i).getId()+"  "+h.get(i).getItemname()+"  "+h.get(i).getCost()+" "+h.get(i).getItemcat()+"  "+h.get(i).getLaunchdate()+"  "+h.get(i).getAvastatus()+" "+h.get(i).getItemdeliverystatus());
		}
		
		
		
		
		//Removing Cart Items
		ne.removeCartItem(2, 3);
		
		
		
			
		
		
		
		
		
	
	}
	

}
