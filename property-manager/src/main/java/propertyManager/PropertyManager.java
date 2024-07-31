package propertyManager;

import entity.Property;

import java.util.List;

public interface PropertyManager {
    void addProperty(Property p);

    List<Property> getProperties();

    List<Property> searchByWidth();

    List<Property> searchBySoldDate();

    void updateSoldDate(int propertyId, String soldDate);

    void deleteProperty(int property_id);
}
