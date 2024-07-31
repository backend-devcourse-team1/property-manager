package propertyManager.impl;

import entity.Property;
import propertyManager.PropertyManager;

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
        return null;
    }

    @Override
    public void updateSoldDate(int propertyId, String soldDate) {

    }

    @Override
    public void deleteProperty(int property_id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://59.27.84.200:3306/workshop", "grepp", "grepp");
            String SQL = "DELETE FROM property WHERE property_id = ?";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, property_id);

            int result = pstmt.executeUpdate();

            System.out.println("property_id에 해당하는 property가 삭제되었습니다" + result);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
