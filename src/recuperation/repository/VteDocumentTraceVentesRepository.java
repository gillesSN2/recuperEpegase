package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteDocumentTraceVentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteDocumentTraceVentesRepository extends JpaRepository<VteDocumentTraceVentes, Long>, JpaSpecificationExecutor<VteDocumentTraceVentes> {

}