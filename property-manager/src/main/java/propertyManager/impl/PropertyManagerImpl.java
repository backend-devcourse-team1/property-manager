package propertyManager.impl;

import entity.Property;
import propertyManager.PropertyManager;

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
        String SQL = "DELETE FROM property_tb WHERE property_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, property_id);
            int result = pstmt.executeUpdate();
            System.out.println("property_id에 해당하는 property가 삭제되었습니다 :”
                + result); } catch(SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

    }
}
