package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteTicketEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteTicketEnteteRepository extends JpaRepository<VteTicketEntete, Long>, JpaSpecificationExecutor<VteTicketEntete> {

}