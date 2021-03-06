package com.dealwallet.webdriver.selenium.Database;

//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DBProgram3
{


	WebDriver d;
	@BeforeMethod
	public void start()
	{
		d=new FirefoxDriver();
	}
	@Test
	public void test()throws Exception
	{


		Connection conn=null;
		try
		{
			// Load the Driver class.
			Class.forName("org.postgresql.Driver");
			// Create the connection using the static getConnection method
			//jdbc:postgresql://
			conn=DriverManager.getConnection("jdbc:postgresql://192.168.10.103:5432/DWDEVTEST","postgres","postgres123");
			//Create a Statement class to execute the SQL statement
			Statement stmt=conn.createStatement();
			//Execute the SQL statement and get the results in a Resultset
			ResultSet rs=stmt.executeQuery("select pp.ammount,pp.productid,p.id,p.detailpageurl from productfeed_product_prices pp,productfeed_products p where p.id=pp.productid");
			// Iterate through the ResultSet, displaying two values
			// for each row using the getString methodS
			//int rowcount=0;
			FileWriter f=new FileWriter("/home/tsssinfotech/Desktop/db.xls");
			f.append("SITE URLS , AMOUNT , PRODUCTID ");
			f.append("\n");
				while(rs.next())
				{

					d.navigate().to(rs.getString("detailpageurl"));
					String ammount=rs.getString("ammount");
					//1
					if(d.getPageSource().contains("2013 Yebhi.com - All Rights Reserved")==true)
					{
						int size=d.findElements(By.xpath("//div[5]/div[2]/div/div[2]/p")).size();
						if(size!=0)
						{
							String s=d.findElement(By.xpath("//div[5]/div[2]/div/div[2]/p")).getText();
							s=s.substring(1);
							String[] parts=s.split(":");
							int len=parts.length;
							if(len==4)
							{
								s=parts[1].replace(",", "").trim();
								if(s.equals(ammount))
								{
									System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are equal");
								}
								else
								{
									System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are NOT equal");
								}
							}
							else
							{
								s=parts[0].replace(",","").trim();
							}

							//System.out.println(len);
							//System.out.println(s);
							//break outerloop;

						}
						else
						{
							System.out.println("NO PRICE TO BE DISPLAYED");
						}
					}
					//2
					else if(d.getPageSource().contains("© 2009-2012 Zoomin")==true)
					{
						int size=d.findElements(By.cssSelector("span.price")).size();
						if(size!=0)
						{
							String s=d.findElement(By.cssSelector("span.price")).getText();
							s=s.substring(3).replace(",","").trim();
							if(s.equals(ammount))
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+"  both are equal");
							}
							else
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are NOT equal");
							}
							//System.out.println(s);
							//break outerloop;
						}
						else
						{
							System.out.println("NO PRICE TO BE DISPLAYED");
						}
					}
					//3
					else if(d.getPageSource().contains("© 2013 healthkart.com")==true)
					{
						int size=d.findElements(By.xpath("//span/span")).size();
						if(size!=0)
						{
							String s=d.findElement(By.xpath("//span/span")).getText();
							s=s.trim().replace(",","");
							if(s.equals(ammount))
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+"  both are equal");
							}
							else
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are NOT equal");
							}
							//System.out.println(s);
							//break outerloop;
						}
						else
						{
							System.out.println("NO PRICE TO BE DISPLAYED");
						}
					}
					//4
					else if(d.getPageSource().contains("buytheprice.com")==true)
					{
						int size=d.findElements(By.xpath("//span/span")).size();
						if(size!=0)
						{
							String s=d.findElement(By.xpath("//span/span")).getText();
							s=s.substring(3).replace(",","").trim();
							if(s.equals(ammount))
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+"  both are equal");
							}
							else
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are NOT equal");
							}
							//System.out.println(s);
							//break outerloop;
						}
						else
						{
							System.out.println("NO PRICE TO BE DISPLAYED");
						}
					}
					//5
					else if(d.getPageSource().contains("Copyright © 2012 snapdeal.com. All rights reserved")==true)
					{
						int size=d.findElements(By.xpath("//strong/span")).size();
						if(size!=0)
						{
							String s=d.findElement(By.xpath("//strong/span")).getText();
							s=s.substring(1).replace(",","").trim();
							if(s.equals(ammount))
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+"  both are equal");
							}
							else
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are NOT equal");
							}
							//System.out.println(s);
							//break outerloop;
						}
						else
						{
							System.out.println("NO PRICE TO BE DISPLAYED");
						}
					}
					//6
					else if(d.getPageSource().contains("Copyright © 2000 - 2012, Times Internet Limited. All rights reserved.")==true)
					{
						int size=d.findElements(By.xpath("//div[3]/div/div/div[2]/span")).size();
						if(size!=0)
						{
							String s=d.findElement(By.xpath("//div[3]/div/div/div[2]/span")).getText();
							s=s.replace(",","").trim();
							if(s.equals(ammount))
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+"  both are equal");
							}
							else
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are NOT equal");
							}
							//System.out.println(s);
							//break outerloop;
						}
						else
						{
							System.out.println("NO PRICE TO BE DISPLAYED");
						}
					}
					//7
					else if(d.getPageSource().contains("© 2011-2013 LetsShop.in, ALL RIGHTS RESERVED.")==true)
					{
						int size=d.findElements(By.xpath("//span/span")).size();
						if(size!=0)
						{
							String s=d.findElement(By.xpath("//span/span")).getText();
							s=s.substring(3).replace(",","").trim();
							if(s.equals(ammount))
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+"  both are equal");
							}
							else
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are NOT equal");
							}
							//System.out.println(s);
							//break outerloop;
						}
						else
						{
							System.out.println("NO PRICE TO BE DISPLAYED");
						}
					}
					//8
					else if(d.getPageSource().contains(" Copyright © 2012 naaptol.com. All rights reserved")==true)
					{
						int size=d.findElements(By.xpath("//li/strong")).size();
						if(size!=0)
						{
							String s=d.findElement(By.xpath("//li/strong")).getText();
							s=s.substring(1).replace(",","").trim();
							if(s.equals(ammount))
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+"  both are equal");
							}
							else
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are NOT equal");
							}
							//System.out.println(s);
							//break outerloop;
						}
						else
						{
							System.out.println("NO PRICE TO BE DISPLAYED");
						}
					}
					//9
					else if(d.getPageSource().contains(" © 2013 homeshop18. all rights reserved.")==true)
					{
						int size=d.findElements(By.id("hs18Price")).size();
						if(size!=0)
						{
							String s=d.findElement(By.id("hs18Price")).getText();
							s=s.substring(1).replace(",","").trim();
							if(s.equals(ammount))
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+"  both are equal");
							}
							else
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are NOT equal");
							}
							//System.out.println(s);
							//break outerloop;
						}
						else
						{
							System.out.println("NO PRICE TO BE DISPLAYED");
						}
					}
					//10
					else if(d.getPageSource().contains(" © 2013 HomeShop18. All rights reserved.")==true)
					{
						int size=d.findElements(By.id("hs18Price")).size();
						if(size!=0)
						{
							String s=d.findElement(By.id("hs18Price")).getText();
							s=s.substring(1).replace(",","").trim();
							if(s.equals(ammount))
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+"  both are equal");
							}
							else
							{
								System.out.println("DB Price::"+ammount+" and Marchent price::"+s+" both are NOT equal");
							}
							//System.out.println(s);
							//break outerloop;
						}
						else
						{
							System.out.println("NO PRICE TO BE DISPLAYED");
						}
					}
//					f.append(rs.getString("detailpageurl"));
//					f.append(",");
//					f.append(rs.getString("ammount"));
//					f.append(",");
//					f.append(rs.getString("productid"));
//					f.append("\n");
//					f.flush();


				}
			f.close();
			//System.out.println("no.of rows are::"+rowcount);
		}
		catch(SQLException se)
		{
			System.out.println("Sql Exception"+se);
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Class not found Exception"+cnfe);
		}

		finally
		{
			try {
				if(conn != null)
					conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	@AfterMethod
	public void stop()
	{
		d.quit();
	}
}




