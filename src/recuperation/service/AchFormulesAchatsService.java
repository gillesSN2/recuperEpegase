package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchFormulesAchats;
import com.yewi.yewicore.recuperation.dtos.AchFormulesAchatsDTO;
import com.yewi.yewicore.recuperation.repository.AchFormulesAchatsRepository;
import com.yewi.yewicore.recuperation.vo.AchFormulesAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFormulesAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFormulesAchatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchFormulesAchatsService {

    @Autowired
    private AchFormulesAchatsRepository achFormulesAchatsRepository;

    public Long save(AchFormulesAchatsVO vO) {
        AchFormulesAchats bean = new AchFormulesAchats();
        BeanUtils.copyProperties(vO, bean);
        bean = achFormulesAchatsRepository.save(bean);
        return bean.getForachId();
    }

    public void delete(Long id) {
        achFormulesAchatsRepository.deleteById(id);
    }

    public void update(Long id, AchFormulesAchatsUpdateVO vO) {
        AchFormulesAchats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achFormulesAchatsRepository.save(bean);
    }

    public AchFormulesAchatsDTO getById(Long id) {
        AchFormulesAchats original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchFormulesAchatsDTO> query(AchFormulesAchatsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchFormulesAchatsDTO toDTO(AchFormulesAchats original) {
        AchFormulesAchatsDTO bean = new AchFormulesAchatsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchFormulesAchats requireOne(Long id) {
        return achFormulesAchatsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
