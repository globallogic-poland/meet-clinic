package meet.clinic.ports;

import meet.clinic.model.Clinic;
import meet.clinic.model.ClinicKey;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends ReactiveCassandraRepository<Clinic, ClinicKey> {

}
