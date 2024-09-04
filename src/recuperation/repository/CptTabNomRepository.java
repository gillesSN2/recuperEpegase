package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptTabNom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptTabNomRepository extends JpaRepository<CptTabNom, Long>, JpaSpecificationExecutor<CptTabNom> {

}