package meet.clinic.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ClinicDto {

    String id;

    String name;

    String district;

    String city;

    String country;

}
