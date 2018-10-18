package meet.clinic.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Clinic {

    String id;

    String name;

    String city;

    String country;

}
