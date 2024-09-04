package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.EduEleves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EduElevesRepository extends JpaRepository<EduEleves, Long>, JpaSpecificationExecutor<EduEleves> {

}