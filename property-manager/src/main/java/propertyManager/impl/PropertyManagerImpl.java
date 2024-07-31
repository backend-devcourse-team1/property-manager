package propertyManager.impl;

import entity.Property;
import io.github.cdimascio.dotenv.Dotenv;
import propertyManager.PropertyManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyManagerImpl implements PropertyManager {
    Connection conn;

    public PropertyManagerImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void addProperty(Property p) {

    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM property";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
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
