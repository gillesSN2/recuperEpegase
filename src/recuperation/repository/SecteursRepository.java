package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Secteurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SecteursRepository extends JpaRepository<Secteurs, Long>, JpaSpecificationExecutor<Secteurs> {

}