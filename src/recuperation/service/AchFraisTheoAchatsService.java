package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchFraisTheoAchats;
import com.yewi.yewicore.recuperation.dtos.AchFraisTheoAchatsDTO;
import com.yewi.yewicore.recuperation.repository.AchFraisTheoAchatsRepository;
import com.yewi.yewicore.recuperation.vo.AchFraisTheoAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFraisTheoAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFraisTheoAchatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchFraisTheoAchatsService {

    @Autowired
    private AchFraisTheoAchatsRepository achFraisTheoAchatsRepository;

    public Long save(AchFraisTheoAchatsVO vO) {
        AchFraisTheoAchats bean = new AchFraisTheoAchats();
        BeanUtils.copyProperties(vO, bean);
        bean = achFraisTheoAchatsRepository.save(bean);
        return bean.getFstId();
    }

    public void delete(Long id) {
        achFraisTheoAchatsRepository.deleteById(id);
    }

    public void update(Long id, AchFraisTheoAchatsUpdateVO vO) {
        AchFraisTheoAchats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achFraisTheoAchatsRepository.save(bean);
    }

    public AchFraisTheoAchatsDTO getById(Long id) {
        AchFraisTheoAchats original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchFraisTheoAchatsDTO> query(AchFraisTheoAchatsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchFraisTheoAchatsDTO toDTO(AchFraisTheoAchats original) {
        AchFraisTheoAchatsDTO bean = new AchFraisTheoAchatsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchFraisTheoAchats requireOne(Long id) {
        return achFraisTheoAchatsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
