package meet.clinic.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Clinic {

    String id; // TODO: possible change to UUID ?

    String name;

    String district;

    String city;

    String country;

}
