package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CategoriesTiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoriesTiersRepository extends JpaRepository<CategoriesTiers, Long>, JpaSpecificationExecutor<CategoriesTiers> {

}