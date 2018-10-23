package meet.clinic.adapters;

import lombok.AllArgsConstructor;
import meet.clinic.dto.ClinicDto;
import meet.clinic.ports.ClinicStorage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
public class ClinicController {

    private final ClinicStorage clinicStorage;

    private final ClinicTransformer clinicTransformer;

    @GetMapping(path = "/clinics", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ClinicDto> getAll() {
        return clinicStorage.findAll()
                .map(clinicTransformer::toDto);
    }

}
