package propertyManager.impl;

import entity.Property;
import propertyManager.PropertyManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PropertyManagerImpl implements PropertyManager {

    Connection conn;

    public PropertyManagerImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addProperty(Property p) {
        String SQL = "insert into property(property_id, paricipant_id, up_date, sold_date, address, width) values(?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, p.getProperty_id());
            ps.setInt(2, p.getParticipant_id());
            ps.setDate(3, (Date) p.getUp_date());
            ps.setDate(4, (Date) p.getSold_date());
            ps.setString(5, p.getAddress());
            ps.setInt(6, p.getWidth());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Property> getProperties() {
        return null;
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
