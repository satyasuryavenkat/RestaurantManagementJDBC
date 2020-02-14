import java.util.*;
public class MenuItem {
	
	private Long id;
	private String itemname;
	private int cost;
	private String itemcat;
	private String avastatus;
	private Date launchdate;
	private String itemdeliverystatus;
	
	public Date getLaunchdate() {
		return launchdate;
	}
	public void setLaunchdate(Date launchdate) {
		this.launchdate = launchdate;
	}
	public Long getId() {
		return id;
	}
	public String getAvastatus() {
		return avastatus;
	}
	public void setAvastatus(String avastatus) {
		this.avastatus = avastatus;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getItemcat() {
		return itemcat;
	}
	public void setItemcat(String itemcat) {
		this.itemcat = itemcat;
	}
	public String getItemdeliverystatus() {
		return itemdeliverystatus;
	}
	public void setItemdeliverystatus(String itemdeliverystatus) {
		this.itemdeliverystatus = itemdeliverystatus;
	}
	
	
	
	
	
	

}
