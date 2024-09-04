package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchNoteDebitLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchNoteDebitLigneRepository extends JpaRepository<AchNoteDebitLigne, Long>, JpaSpecificationExecutor<AchNoteDebitLigne> {

}