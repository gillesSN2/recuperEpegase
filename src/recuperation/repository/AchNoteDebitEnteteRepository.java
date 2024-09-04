package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchNoteDebitEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchNoteDebitEnteteRepository extends JpaRepository<AchNoteDebitEntete, Long>, JpaSpecificationExecutor<AchNoteDebitEntete> {

}