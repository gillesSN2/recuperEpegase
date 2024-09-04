package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Groupes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroupesRepository extends JpaRepository<Groupes, Long>, JpaSpecificationExecutor<Groupes> {

}