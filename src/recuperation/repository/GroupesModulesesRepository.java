package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.GroupesModuleses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroupesModulesesRepository extends JpaRepository<GroupesModuleses, String>, JpaSpecificationExecutor<GroupesModuleses> {

}