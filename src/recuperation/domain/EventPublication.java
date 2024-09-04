package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "event_publication")
public class EventPublication implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "completion_date")
    private LocalDateTime completionDate;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "listener_id")
    private String listenerId;

    @Column(name = "publication_date")
    private LocalDateTime publicationDate;

    @Column(name = "serialized_event")
    private String serializedEvent;

}
