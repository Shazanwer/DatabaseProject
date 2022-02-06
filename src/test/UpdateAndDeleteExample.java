package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateAndDeleteExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");

		Statement stm = dbcon.createStatement();	

		stm.executeUpdate("Delete from eproduct where name = 'tablet'");
		stm.executeUpdate("insert into eproduct(name, price, date_added) values('tablet', '1400', now())");
		stm.executeUpdate("update eproduct set price = '1900' where name = 'tablet'");

		ResultSet result = stm.executeQuery("Select * from eproduct");

		while (result.next()) {
			System.out.println(result.getInt("ID") + "," + result.getString("name") + "," + result.getInt("price") + ","
					+ result.getTimestamp("date_added"));

		}

	}

}
