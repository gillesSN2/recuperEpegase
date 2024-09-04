package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.EventPublication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventPublicationRepository extends JpaRepository<EventPublication, String>, JpaSpecificationExecutor<EventPublication> {

}