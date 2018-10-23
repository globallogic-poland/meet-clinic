package meet.clinic.adapters;

import lombok.AllArgsConstructor;
import meet.clinic.dto.ClinicDto;
import meet.clinic.model.Clinic;
import meet.clinic.ports.ClinicBindings;
import meet.clinic.ports.ClinicStorage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import reactor.core.publisher.Flux;

import static meet.clinic.ports.ClinicBindings.CLINIC_CREATE_REQUESTS;
import static meet.clinic.ports.ClinicBindings.CLINIC_CREATE_RESULTS;

@AllArgsConstructor
@EnableBinding(ClinicBindings.class)
public class ClinicProcessor {

    private final ClinicStorage clinicStorage;

    private final ClinicTransformer clinicTransformer;

    @StreamListener
    @Output(CLINIC_CREATE_RESULTS)
    public Flux<ClinicDto> insert(@Input(CLINIC_CREATE_REQUESTS) Flux<ClinicDto> clinicFlux) {
        Flux<Clinic> clinicPublisher = clinicFlux.map(clinicTransformer::fromDto);
        return clinicStorage.insert(clinicPublisher)
                .map(clinicTransformer::toDto);
    }

}
