package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Allargsconstructor;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Property {
    private int propertyId;
    private int participantId;
    private Date upDate;
    private Date soldDate;
    private String address;
    private int width;

    public Property() {
    }
}
