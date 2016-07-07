import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Customers {

	static Connection conn;

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver"; // org.h2.Driver
	static final String DB_URL = "jdbc:h2:~/test";

	// Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	final JFrame firstFrame = new JFrame("Krishna Traders");

	public static void main(String[] args) {

		Statement stmt = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName("org.h2.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating Customers table in given database...");
			stmt = conn.createStatement();

			// COMPANYNAME, DATE, DELIVEREDTO, QUANTITY, RATE, AMOUNT,
			// DESCRIPTION

			String customerSqlStatement = "CREATE TABLE CUSTOMERS "
					+ "(CHALANNUMBER INTEGER NOT NULL PRIMARY KEY, "
					+ " COMPANYNAME VARCHAR(255), "
					+ " ORDERDATE VARCHAR(20), "
					+ " DELIVEREDTO VARCHAR(300), " + "QUANTITY VARCHAR(255), "
					+ " RATE VARCHAR(100), " + "AMOUNT VARCHAR(100), "
					+ "DESCRIPTION VARCHAR(300))";

			stmt.executeUpdate(customerSqlStatement);

			String dyingSqlStatement = "CREATE TABLE DYING "
					+ "(CHALANNUMBER INTEGER NOT NULL PRIMARY KEY, "
					+ " SENT_TO VARCHAR(300), " + " ORDER_DATE VARCHAR(20), "
					+ " QUANTITY VARCHAR(255), " + " METERS VARCHAR(255), "
					+ "NUMBER_OF_SHAWLS VARCHAR(100))";

			stmt.executeUpdate(dyingSqlStatement);
			
			String finishingSqlStatement = "CREATE TABLE FINISHING "
					+ "(CHALANNUMBER INTEGER NOT NULL PRIMARY KEY, "
					+ " SENT_TO VARCHAR(300), " + " ORDER_DATE VARCHAR(20), "
					+ " QUANTITY VARCHAR(255), " + " METERS VARCHAR(255), "
					+ "NUMBER_OF_SHAWLS VARCHAR(100))";

			stmt.executeUpdate(finishingSqlStatement);

			System.out.println("tables made");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}

	// ADD CUSTOMER
	/*
	 * Adds the customer to database.
	 */
	public void addCustomer(String chalanNumber, String companyName,
			String date, String deliveredTo, String quantity, String rate,
			String amount, String description) {

		Statement stmt = null;
		int cId = 0;
		System.out.println("Trying to add customer to database");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				cId = (rs.getInt(1));
			}

			String addCustomerQuery = "INSERT INTO CUSTOMERS (CHALANNUMBER, COMPANYNAME, ORDERDATE, DELIVEREDTO, QUANTITY, RATE, AMOUNT, DESCRIPTION) VALUES ('"
					+ chalanNumber
					+ "','"
					+ companyName
					+ "','"
					+ date
					+ "','"
					+ deliveredTo
					+ "','"
					+ quantity
					+ "','"
					+ rate
					+ "','"
					+ amount + "','" + description + "')";

			if (companyName.isEmpty() || deliveredTo.isEmpty()
					|| quantity.isEmpty() || rate.isEmpty() || amount.isEmpty()
					|| description.isEmpty()) {
				JOptionPane
						.showMessageDialog(
								firstFrame,
								"One of the field is empty. Plesae fill the field before continuing.",
								"Emtpy Field Error", JOptionPane.ERROR_MESSAGE);

			} else {
				stmt.executeUpdate(addCustomerQuery);
				System.out.println("added customer to database");
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public void addDyingInformation(String sentTo, String date,
			String chalanNumber, String quantity, String meters,
			String totalShawls) {

		Statement stmt = null;
		int cId = 0;
		System.out.println("Trying to add dying to database");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			int chalanNumberWorkingWith = Integer.parseInt(chalanNumber);
			String dyingQuery = "SELECT * FROM CUSTOMERS WHERE CHALANNUMBER ='"
					+ chalanNumberWorkingWith + "'";

			ResultSet rs = stmt.executeQuery(dyingQuery);

			if (rs.absolute(1)) {
				System.out.println("Data found");
				String addDyingQuery = "INSERT INTO DYING (CHALANNUMBER, SENT_TO, ORDER_DATE, QUANTITY, METERS, NUMBER_OF_SHAWLS) VALUES ('"
						+ chalanNumber
						+ "','"
						+ sentTo
						+ "','"
						+ date
						+ "','"
						+ quantity
						+ "','"
						+ meters
						+ "','"
						+ totalShawls
						+ "')";

				if (chalanNumber.isEmpty() || sentTo.isEmpty()
						|| quantity.isEmpty() || meters.isEmpty()
						|| totalShawls.isEmpty() || date.isEmpty()) {
					JOptionPane
							.showMessageDialog(
									firstFrame,
									"One of the field is empty. Plesae fill the field before continuing.",
									"Emtpy Field Error",
									JOptionPane.ERROR_MESSAGE);

				}

				else {
					System.out.println("Adding dying information to database....");
					stmt.executeUpdate(addDyingQuery);
					System.out.println("Dying information to database");
				}
			} else {
				JOptionPane
						.showMessageDialog(
								firstFrame,
								"Chalan number not found. \nPlease enter a valid Chalan Number",
								"Chalan number not found",
								JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}

	
	public void addFinishingInformation(String sentTo, String date,
			String chalanNumber, String quantity, String meters,
			String totalShawls) {

		Statement stmt = null;
		int cId = 0;
		System.out.println("Trying to add dying to database");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			int chalanNumberWorkingWith = Integer.parseInt(chalanNumber);
			String dyingQuery = "SELECT * FROM CUSTOMERS WHERE CHALANNUMBER ='"
					+ chalanNumberWorkingWith + "'";

			ResultSet rs = stmt.executeQuery(dyingQuery);

			if (rs.absolute(1)) {
				System.out.println("Data found");
				String addDyingQuery = "INSERT INTO FINISHING (CHALANNUMBER, SENT_TO, ORDER_DATE, QUANTITY, METERS, NUMBER_OF_SHAWLS) VALUES ('"
						+ chalanNumber
						+ "','"
						+ sentTo
						+ "','"
						+ date
						+ "','"
						+ quantity
						+ "','"
						+ meters
						+ "','"
						+ totalShawls
						+ "')";

				if (chalanNumber.isEmpty() || sentTo.isEmpty()
						|| quantity.isEmpty() || meters.isEmpty()
						|| totalShawls.isEmpty() || date.isEmpty()) {
					JOptionPane
							.showMessageDialog(
									firstFrame,
									"One of the field is empty. Plesae fill the field before continuing.",
									"Emtpy Field Error",
									JOptionPane.ERROR_MESSAGE);

				}

				else {
					System.out.println("Adding dying information to database....");
					stmt.executeUpdate(addDyingQuery);
					System.out.println("Dying information to database");
				}
			} else {
				JOptionPane
						.showMessageDialog(
								firstFrame,
								"Chalan number not found. \nPlease enter a valid Chalan Number",
								"Chalan number not found",
								JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}


	// DELETE CUSTOMER
	public boolean deleteCustomer(int id) {

		Statement stmt = null;
		int cId = 0;
		System.out.println("Trying to delete customer to database");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			String findCustomerToDelete = "SELECT CUSTOMERID FROM CUSTOMERS WHERE CUSTOMERID ='"
					+ id + "'";
			stmt.execute(findCustomerToDelete);

			ResultSet newRs = stmt.getResultSet();
			boolean customerToDeleteFound = newRs.next();

			if (customerToDeleteFound) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					cId = (rs.getInt(1));
				}
				String deleteCustomerQuery = "DELETE FROM CUSTOMERS WHERE CUSTOMERID ='"
						+ id + "'";
				stmt.executeUpdate(deleteCustomerQuery);
				return true;
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return false;
	}
	
	/*
	 * This function gets the chalan number given the chalan id
	 * Fields retreived are :Quantity (weight) , meters, number of shawls
	 */

	// UPDATE CUSTOMER
	public void updateCustomer(int id, String fNameUpdate, String lNameUpdate) {

		Statement stmt = null;
		int cId = 0;
		System.out.println("Trying to update customer to database");
		String orignalFirstName = null;
		String orignalLastName = null;

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			String updateCustomerQuery = "SELECT * FROM CUSTOMERS WHERE CUSTOMERID ='"
					+ id + "'";

			stmt.execute(updateCustomerQuery);
			ResultSet newRs = stmt.getResultSet();

			if (newRs.absolute(1)) {
				orignalFirstName = newRs.getString(2);
				orignalLastName = newRs.getString(3);
				System.out.println("first:" + orignalFirstName + " and last: "
						+ orignalLastName);
			}

			if ((!(fNameUpdate.equals(orignalFirstName)))
					|| (!(lNameUpdate.equals(orignalLastName)))) {
				String updateCustomer = "UPDATE CUSTOMERS SET FIRSTNAME= '"
						+ fNameUpdate + "', LASTNAME='" + lNameUpdate
						+ "' WHERE CUSTOMERID= '" + id + "'";
				stmt.executeUpdate(updateCustomer);
			} else {
				System.out.println("Nothing was changed.");
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}

	public List<String> getCustomerUsingId(int id) {

		String firstName = null;
		String lastName = null;

		Statement stmt = null;

		List<String> customerValues = null;
		String getCustomerQuery = "SELECT * FROM CUSTOMERS WHERE CUSTOMERID ='"
				+ id + "'";

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			stmt.execute(getCustomerQuery);
			ResultSet rs = stmt.getResultSet();
			if (rs.absolute(1)) {
				customerValues = new ArrayList<String>();
				customerValues.add(rs.getString(2));
				customerValues.add(rs.getString(3));
			}
		}

		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return customerValues;

	}
}
