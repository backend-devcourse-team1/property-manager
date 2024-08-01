package propertyManager.impl;

import entity.Property;
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
        String SQL = "insert into property(property_id, paricipant_id, up_date, sold_date, address, width) values(?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, p.getPropertyId());
            ps.setInt(2, p.getParticipantId());
            ps.setDate(3, (Date) p.getUpDate());
            ps.setDate(4, (Date) p.getSoldDate());
            ps.setString(5, p.getAddress());
            ps.setInt(6, p.getWidth());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT FROM property";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Property property = new Property();
                property.setPropertyId(rs.getInt("property_id"));
                property.setParticipantId(rs.getInt("participant_id"));
                property.setUpDate(rs.getDate("up_date"));
                property.setSoldDate(rs.getDate("sold_date"));
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
        String sql = "SELECT FROM property ORDER BY width desc";
        List<Property> resultList = new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            rs = pstmt.executeQuery();
            while (rs.next()) {
                resultList.add(new Property(
                        rs.getInt("property_id"),
                        rs.getInt("participant_id"),
                        rs.getDate("up_date"),
                        rs.getDate("sold_date"),
                        rs.getString("address"),
                        rs.getInt("width")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }

    @Override
    public List<Property> searchBySoldDate() {
        String sql = "select from property order by sold_date desc ";
        List<Property> resultList = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultList.add(new Property(
                        rs.getInt("property_id"),
                        rs.getInt("participant_id"),
                        rs.getDate("up_date"),
                        rs.getDate("sold_date"),
                        rs.getString("address"),
                        rs.getInt("width")
                ));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }

    @Override
    public void updateSoldDate(int propertyId, String soldDate) {
        String SQL = "UPDATE property SET sold_date = ? WHERE property_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            int result = pstmt.executeUpdate();
            System.out.println("SQL 실행 완료");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try{
                if (conn != null) conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override public void deleteProperty(int property_id) {
        String SQL = "DELETE FROM property WHERE property_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, property_id);
            int result = pstmt.executeUpdate();
            System.out.println("property_id에 해당하는 property가 삭제되었습니다 :" + result);
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}


