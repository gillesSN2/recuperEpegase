package recuperation.service;

import com.yewi.yewicore.recuperation.domain.EduExercicesEducation;
import com.yewi.yewicore.recuperation.dtos.EduExercicesEducationDTO;
import com.yewi.yewicore.recuperation.repository.EduExercicesEducationRepository;
import com.yewi.yewicore.recuperation.vo.EduExercicesEducationQueryVO;
import com.yewi.yewicore.recuperation.vo.EduExercicesEducationUpdateVO;
import com.yewi.yewicore.recuperation.vo.EduExercicesEducationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EduExercicesEducationService {

    @Autowired
    private EduExercicesEducationRepository eduExercicesEducationRepository;

    public Long save(EduExercicesEducationVO vO) {
        EduExercicesEducation bean = new EduExercicesEducation();
        BeanUtils.copyProperties(vO, bean);
        bean = eduExercicesEducationRepository.save(bean);
        return bean.getExeeduId();
    }

    public void delete(Long id) {
        eduExercicesEducationRepository.deleteById(id);
    }

    public void update(Long id, EduExercicesEducationUpdateVO vO) {
        EduExercicesEducation bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        eduExercicesEducationRepository.save(bean);
    }

    public EduExercicesEducationDTO getById(Long id) {
        EduExercicesEducation original = requireOne(id);
        return toDTO(original);
    }

    public Page<EduExercicesEducationDTO> query(EduExercicesEducationQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private EduExercicesEducationDTO toDTO(EduExercicesEducation original) {
        EduExercicesEducationDTO bean = new EduExercicesEducationDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private EduExercicesEducation requireOne(Long id) {
        return eduExercicesEducationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
