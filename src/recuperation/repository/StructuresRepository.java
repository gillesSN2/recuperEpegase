package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Structures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StructuresRepository extends JpaRepository<Structures, Long>, JpaSpecificationExecutor<Structures> {

}