package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteNoteDebitEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteNoteDebitEnteteRepository extends JpaRepository<VteNoteDebitEntete, Long>, JpaSpecificationExecutor<VteNoteDebitEntete> {

}