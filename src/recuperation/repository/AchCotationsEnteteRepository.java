package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchCotationsEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchCotationsEnteteRepository extends JpaRepository<AchCotationsEntete, Long>, JpaSpecificationExecutor<AchCotationsEntete> {

}