package propertyManager.impl;

import entity.Property;
import propertyManager.PropertyManager;
import java.sql.*;

import java.util.List;

public class PropertyManagerImpl implements PropertyManager {
    @Override
    public void addProperty(Property p) {

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
        sql = "select * from property order by sold_date desc ";
        List<Property> resultList = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Property property = new Property(
                        rs.getString("participant_id"),
                        rs.getDate("up_date"),
                        rs.getDate("sold_date"),
                        rs.getString("address"),
                        rs.getInt("width")
                );
                resultList.add(property);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }
    @Override
    public void updateSoldDate(int propertyId, String soldDate) {

    }

    @Override
    public void deleteProperty(int property_id) {

    }
}
