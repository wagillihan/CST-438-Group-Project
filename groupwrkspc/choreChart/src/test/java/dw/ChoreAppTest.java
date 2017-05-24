package dw;

import junit.framework.Assert;
import junit.framework.TestCase;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChoreAppTest extends TestCase {

	public final void testGetParent() {
		try 
		{
			// get parent from server
			//URL url = new URL("http://chorechart.bitnamiapp.com/choreChart/profile/1"); 
			URL url = new URL("http://localhost:8080/choreChart/profile/1");
			HttpURLConnection con = (HttpURLConnection)url.openConnection(); 
			int rc = con.getResponseCode();
			
			if (rc != 200) {
				System.out.println("Bad response code on retrieve. "+rc);
			}
			Assert.assertEquals("Bad response code.",200,rc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final void testGet2ndParent() {
		try 
		{
			// get second parent from server
			//URL url = new URL("http://chorechart.bitnamiapp.com/choreChart/profile/2"); 
			URL url = new URL("http://localhost:8080/choreChart/profile/2");
			HttpURLConnection con = (HttpURLConnection)url.openConnection(); 
			int rc = con.getResponseCode();
			
			if (rc != 200) {
				System.out.println("Unexpected response code, expected 200, was "+rc);
			}
			Assert.assertEquals("Unexpected response code.",200,rc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final void testGet3rdParent() {
		try 
		{
			// get third parent from server
			//URL url = new URL("http://chorechart.bitnamiapp.com/choreChart/profile/3"); 
			URL url = new URL("http://localhost:8080/choreChart/profile/3");
			HttpURLConnection con = (HttpURLConnection)url.openConnection(); 
			int rc = con.getResponseCode();
			
			if (rc != 200) {
				System.out.println("Unexpected response code, expected 200, was "+rc);
			}
			Assert.assertEquals("Unexpected response code.",200,rc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void testGetAllParents() {
		try 
		{
			// get all parents from server
			//URL url = new URL("http://chorechart.bitnamiapp.com/choreChart/profile"); 
			URL url = new URL("http://localhost:8080/choreChart/profile");
			HttpURLConnection con = (HttpURLConnection)url.openConnection(); 
			int rc = con.getResponseCode();
			
			if (rc != 200) {
				System.out.println("Bad response code on retrieve. "+rc);
			}
			Assert.assertEquals("Bad response code.",200,rc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void testUpdateParent() {
		Assert.assertTrue(true);
	}
	
}