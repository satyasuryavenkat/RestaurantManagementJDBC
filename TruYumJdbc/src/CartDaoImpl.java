import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
import java.util.*;
public class CartDaoImpl {
	
	
	public void addCartItem(long userid,long menuid)
	{
		
		
		try{
			Connection co = ConnectionHandler.getConnection();
			
			
			PreparedStatement ps=co.prepareStatement("insert into cart values(?,?)");
			ps.setLong(1,userid);
			ps.setLong(2,menuid);
			
			
			int k= ps.executeUpdate();
			if(k==1)
			{
				System.out.println("Item added to cart");
			}
			else
			{
				System.out.println("Item is not added");
			}
			
		}
		catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
		
	}
	
	
	
	
	public List<MenuItem> getAllcartItems(long userid)
	{
		List<MenuItem> cart = new ArrayList<MenuItem>();
		//List<Long> menuid = new ArrayList<Long>();
		try{
			Connection co = ConnectionHandler.getConnection();
			
			int cost=0;
			PreparedStatement ps=co.prepareStatement("select itemid from cart where userid='"+userid+"'");
			ResultSet rs= ps.executeQuery();
			
			
			
			while(rs.next())
			{
				
				MenuItem ob = new MenuItem();
				long ide=rs.getLong(1);
				PreparedStatement p=co.prepareStatement("select * from itemmenu where itemid='"+ide+"'");
				ResultSet r= p.executeQuery();
				r.next();
				ob.setId(r.getLong(1));
				ob.setItemname(r.getString(2));
				int c=r.getInt(3);
				ob.setCost(c);
				ob.setItemcat(r.getString(4));
				ob.setLaunchdate(r.getDate(5));
				ob.setAvastatus(r.getString(6));
				ob.setItemdeliverystatus(r.getString(7));
				cost=cost+c;
				cart.add(ob);
				
			}
			System.out.println("The Total Cart Cost "+cost);
			
			
		}
		
		catch(SQLException e)
	    {
	        e.printStackTrace();
	    }
	    catch(ClassNotFoundException e)
	    {
	        e.printStackTrace();
	    }
		
		
		return cart;
		
		
		
	}
	
	public void removeCartItem(long userid, long menuitemid )
	{
		try{
		Connection co = ConnectionHandler.getConnection();
		PreparedStatement ps=co.prepareStatement("delete from cart where userid='"+userid+"' and itemid='"+menuitemid+"'");
		int k= ps.executeUpdate();
		
		if(k==1)
		{
			System.out.println("Deleted Successfully");
		}
		else
		{
			System.out.println("Not Found");
		}
		}
		catch(SQLException e)
	    {
	        e.printStackTrace();
	    }
	    catch(ClassNotFoundException e)
	    {
	        e.printStackTrace();
	    }
	}
	
	
	

}
