package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmMailsPj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmMailsPjRepository extends JpaRepository<CmmMailsPj, Long>, JpaSpecificationExecutor<CmmMailsPj> {

}