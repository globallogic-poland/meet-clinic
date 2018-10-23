package meet.clinic.adapters;

import meet.clinic.dto.ClinicDto;
import meet.clinic.model.Clinic;
import meet.clinic.model.ClinicKey;
import org.springframework.stereotype.Component;

@Component
public class ClinicTransformer {

    public ClinicDto toDto(Clinic clinic) {

        ClinicKey key = clinic.getKey();

        return ClinicDto.builder()
                .id(key.getId())
                .country(key.getCountry())
                .city(key.getCity())
                .district(key.getDistrict())
                .name(clinic.getName())
                .build();
    }

    public Clinic fromDto(ClinicDto clinicDto) {

        ClinicKey clinicKey = ClinicKey.builder()
                .id(clinicDto.getId())
                .country(clinicDto.getCountry())
                .city(clinicDto.getCity())
                .district(clinicDto.getDistrict())
                .build();

        return Clinic.builder()
                .key(clinicKey)
                .name(clinicDto.getName())
                .build();
    }
}
