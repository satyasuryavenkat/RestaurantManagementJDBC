import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
import java.util.*;
public class MenuItemDaoImpl {
	
	
	
public void filldatabase(MenuItem obl)
{
	
try{           
        
        Connection co=ConnectionHandler.getConnection();      
        
       PreparedStatement ps=co.prepareStatement("insert into itemmenu values(?,?,?,?,?,?,?)");
       ps.setLong(1, obl.getId());
		ps.setString(2, obl.getItemname());
		ps.setInt(3, obl.getCost());
		ps.setString(4, obl.getItemcat());
		ps.setDate(5, new java.sql.Date(obl.getLaunchdate().getTime()));
		ps.setString(6, obl.getAvastatus());
		ps.setString(7, obl.getItemdeliverystatus());
       int k= ps.executeUpdate();
        
        if(k==1)
        {
            System.out.println("Item details added successfully");
           
           // return true;
            
        }
        else
        {
            System.out.println("Addition not done");
            //return false;
            
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
		
public List<MenuItem> getMenuItemListAdmin(){
	List<MenuItem> list= new ArrayList<MenuItem>();
	try{
		Connection co = ConnectionHandler.getConnection();
		
		
		PreparedStatement ps=co.prepareStatement("select * from itemmenu");
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			MenuItem ob = new MenuItem();
			ob.setId(rs.getLong(1));
			ob.setItemname(rs.getString(2));
			ob.setCost(rs.getInt(3));
			ob.setItemcat(rs.getString(4));
			ob.setLaunchdate(rs.getDate(5));
			ob.setAvastatus(rs.getString(6));
			ob.setItemdeliverystatus(rs.getString(7));
			list.add(ob);
			
			
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
	
	return list;
}


public List<MenuItem> getMenuItemListCustomer(){
List<MenuItem> cuslist= new ArrayList<MenuItem>();
try{
Connection co = ConnectionHandler.getConnection();


PreparedStatement ps=co.prepareStatement("select * from itemmenu where itemavastatus='yes' and year(itemlaunchdate)<='2020' ");
ResultSet rs= ps.executeQuery();
while(rs.next())
{
	MenuItem ob = new MenuItem();
	ob.setId(rs.getLong(1));
	ob.setItemname(rs.getString(2));
	ob.setCost(rs.getInt(3));
	ob.setItemcat(rs.getString(4));
	ob.setLaunchdate(rs.getDate(5));
	ob.setAvastatus(rs.getString(6));
	ob.setItemdeliverystatus(rs.getString(7));
	cuslist.add(ob);
	
	
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

return cuslist;
}


public MenuItem getMenuItem(long itemid)
{
	
	MenuItem obj = new MenuItem();
	try{
		Connection co = ConnectionHandler.getConnection();


		PreparedStatement ps=co.prepareStatement("select * from itemmenu where itemid=?");
		ps.setLong(1, itemid);
		ResultSet rs= ps.executeQuery();
		
		rs.next();
			obj.setId(rs.getLong(1));
			obj.setItemname(rs.getString(2));
			obj.setCost(rs.getInt(3));
			obj.setItemcat(rs.getString(4));
			obj.setLaunchdate(rs.getDate(5));
			obj.setAvastatus(rs.getString(6));
			obj.setItemdeliverystatus(rs.getString(7));
			
	}
		
			


		catch(SQLException e)
		{
		e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
		e.printStackTrace();
		}

	return obj;
}

public void editMenuItem(MenuItem pq){
	
	try{
		Connection co = ConnectionHandler.getConnection();

		long itemid=pq.getId();
		
		PreparedStatement ps=co.prepareStatement("update itemmenu set itemname='"+pq.getItemname()+"',itemcost='"+pq.getCost()+"',itemcat='"+pq.getItemcat()+"',itemlaunchdate='"+pq.getLaunchdate()+"',itemavastatus='"+pq.getAvastatus()+"',itemdeliverystatus='"+pq.getItemdeliverystatus()+"' where itemid='"+itemid+"'");
		
		
		//ps.setString(2, pq.getItemname());
		//ps.setInt(3, pq.getCost());
		//ps.setString(4, pq.getItemcat());
	//	ps.setDate(5, new java.sql.Date(pq.getLaunchdate().getTime()));
	//	ps.setString(6, pq.getAvastatus());
	//	ps.setString(7, pq.getItemdeliverystatus());
		
		int k= ps.executeUpdate();
			
			if(k==1)
			{
				System.out.println("Updated");
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
