package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.EduExercicesEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EduExercicesEducationRepository extends JpaRepository<EduExercicesEducation, Long>, JpaSpecificationExecutor<EduExercicesEducation> {

}