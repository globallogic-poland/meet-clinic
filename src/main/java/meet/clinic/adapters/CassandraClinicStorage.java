package meet.clinic.adapters;

import lombok.AllArgsConstructor;
import meet.clinic.model.Clinic;
import meet.clinic.model.ClinicKey;
import meet.clinic.ports.ClinicRepository;
import meet.clinic.ports.ClinicStorage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CassandraClinicStorage implements ClinicStorage {

    private final ClinicRepository clinicRepository;

    @Override
    public Mono<Clinic> findById(ClinicKey id) {
        return clinicRepository.findById(id);
    }

    @Override
    public Flux<Clinic> insert(Flux<Clinic> clinicFlux) {
        return clinicRepository.insert(clinicFlux.map(this::applyId));
    }

    @Override
    public Flux<Clinic> findAll() {
        return clinicRepository.findAll();
    }

    private Clinic applyId(Clinic clinic) {
        clinic.getKey().setId(UUID.randomUUID().toString());
        return clinic;
    }
}
