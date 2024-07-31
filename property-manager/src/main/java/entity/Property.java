package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Allargsconstructor
public class Property {
    private int property_id;
    private int participant_id;
    private Date up_date;
    private Date sold_date;
    private String address;
    private int width;
}
