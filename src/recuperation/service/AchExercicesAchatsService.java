package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchExercicesAchats;
import com.yewi.yewicore.recuperation.dtos.AchExercicesAchatsDTO;
import com.yewi.yewicore.recuperation.repository.AchExercicesAchatsRepository;
import com.yewi.yewicore.recuperation.vo.AchExercicesAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchExercicesAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchExercicesAchatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchExercicesAchatsService {

    @Autowired
    private AchExercicesAchatsRepository achExercicesAchatsRepository;

    public Long save(AchExercicesAchatsVO vO) {
        AchExercicesAchats bean = new AchExercicesAchats();
        BeanUtils.copyProperties(vO, bean);
        bean = achExercicesAchatsRepository.save(bean);
        return bean.getExeachId();
    }

    public void delete(Long id) {
        achExercicesAchatsRepository.deleteById(id);
    }

    public void update(Long id, AchExercicesAchatsUpdateVO vO) {
        AchExercicesAchats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achExercicesAchatsRepository.save(bean);
    }

    public AchExercicesAchatsDTO getById(Long id) {
        AchExercicesAchats original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchExercicesAchatsDTO> query(AchExercicesAchatsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchExercicesAchatsDTO toDTO(AchExercicesAchats original) {
        AchExercicesAchatsDTO bean = new AchExercicesAchatsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchExercicesAchats requireOne(Long id) {
        return achExercicesAchatsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
