package meet.clinic.ports;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ClinicBindings {

    String CLINIC_CREATE_REQUESTS = "clinic-create-requests";
    String CLINIC_CREATE_RESULTS = "clinic-create-results";

    @Input(CLINIC_CREATE_REQUESTS)
    SubscribableChannel createClinicRequests();

    @Output(CLINIC_CREATE_RESULTS)
    MessageChannel createClinicResults();
}