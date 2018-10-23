package meet.clinic.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table
public class Clinic {

    @PrimaryKey
    private ClinicKey key;

    @Column
    private String name;

}
