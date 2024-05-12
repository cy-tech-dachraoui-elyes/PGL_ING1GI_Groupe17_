package org.example.projetgenielogiciel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LoadCustomers
{
    private static final Logger LOGGER = Logger.getLogger(LoadCustomers.class.getName());
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Librarian";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static List<Customer> loadCustomers()
    {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Customer"))
        {
            while (rs.next())
            {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Date birthDate = rs.getDate("birthDate");
                customers.add(new Customer(id, firstName, lastName, birthDate));
            }
        }
        catch (SQLException e)
        {
            LOGGER.log(Level.SEVERE, "Ah error occurred while loading customers",e);
        }
        return customers;
    }
}
