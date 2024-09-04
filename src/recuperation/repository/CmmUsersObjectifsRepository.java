package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmUsersObjectifs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmUsersObjectifsRepository extends JpaRepository<CmmUsersObjectifs, Long>, JpaSpecificationExecutor<CmmUsersObjectifs> {

}