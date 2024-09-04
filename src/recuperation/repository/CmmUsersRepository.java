package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmUsersRepository extends JpaRepository<CmmUsers, Long>, JpaSpecificationExecutor<CmmUsers> {

}