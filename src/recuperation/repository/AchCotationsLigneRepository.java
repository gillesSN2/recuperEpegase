package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchCotationsLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchCotationsLigneRepository extends JpaRepository<AchCotationsLigne, Long>, JpaSpecificationExecutor<AchCotationsLigne> {

}