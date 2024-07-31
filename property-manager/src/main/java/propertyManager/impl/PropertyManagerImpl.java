package propertyManager.impl;

import entity.Property;
import io.github.cdimascio.dotenv.Dotenv;
import propertyManager.PropertyManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyManagerImpl implements PropertyManager {
    private static final Dotenv dotenv = Dotenv.load();

    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void addProperty(Property p) {

    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM property";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Property property = new Property();
                property.setProperty_id(rs.getInt("property_id"));
                property.setParticipant_id(rs.getInt("participant_id"));
                property.setUp_date(rs.getDate("up_date"));
                property.setSold_date(rs.getDate("sold_date"));
                property.setAddress(rs.getString("address"));
                property.setWidth(rs.getInt("width"));
                properties.add(property);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Override
    public List<Property> searchByWidth() {
        return null;
    }

    @Override
    public List<Property> searchBySoldDate() {
        return null;
    }

    @Override
    public void updateSoldDate(int propertyId, String soldDate) {

    }

    @Override
    public void deleteProperty(int property_id) {

    }
}
