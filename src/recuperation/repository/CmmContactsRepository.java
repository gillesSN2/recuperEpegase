package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmContactsRepository extends JpaRepository<CmmContacts, Long>, JpaSpecificationExecutor<CmmContacts> {

}