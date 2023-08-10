package ku.cs.Restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private UUID id;
    // UUID เดายาก ปลอดภัยแต่เปลืองพื้นที่
    private String name;
    private double rating;
    private String location;
}
