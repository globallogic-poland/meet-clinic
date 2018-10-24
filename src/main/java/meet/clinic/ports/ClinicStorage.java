package meet.clinic.ports;

import meet.clinic.model.Clinic;
import meet.clinic.model.ClinicKey;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClinicStorage {

    Mono<Clinic> findById(ClinicKey id);

    Flux<Clinic> insert(Flux<Clinic> clinicFlux);

    Flux<Clinic> findAll();

}
