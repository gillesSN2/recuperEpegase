package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class EventPublicationQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private LocalDateTime completionDate;

    private String eventType;

    private String listenerId;

    private LocalDateTime publicationDate;

    private String serializedEvent;

}
