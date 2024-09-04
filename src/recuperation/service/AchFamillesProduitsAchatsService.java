package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchFamillesProduitsAchats;
import com.yewi.yewicore.recuperation.dtos.AchFamillesProduitsAchatsDTO;
import com.yewi.yewicore.recuperation.repository.AchFamillesProduitsAchatsRepository;
import com.yewi.yewicore.recuperation.vo.AchFamillesProduitsAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFamillesProduitsAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFamillesProduitsAchatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchFamillesProduitsAchatsService {

    @Autowired
    private AchFamillesProduitsAchatsRepository achFamillesProduitsAchatsRepository;

    public Long save(AchFamillesProduitsAchatsVO vO) {
        AchFamillesProduitsAchats bean = new AchFamillesProduitsAchats();
        BeanUtils.copyProperties(vO, bean);
        bean = achFamillesProduitsAchatsRepository.save(bean);
        return bean.getFamachId();
    }

    public void delete(Long id) {
        achFamillesProduitsAchatsRepository.deleteById(id);
    }

    public void update(Long id, AchFamillesProduitsAchatsUpdateVO vO) {
        AchFamillesProduitsAchats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achFamillesProduitsAchatsRepository.save(bean);
    }

    public AchFamillesProduitsAchatsDTO getById(Long id) {
        AchFamillesProduitsAchats original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchFamillesProduitsAchatsDTO> query(AchFamillesProduitsAchatsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchFamillesProduitsAchatsDTO toDTO(AchFamillesProduitsAchats original) {
        AchFamillesProduitsAchatsDTO bean = new AchFamillesProduitsAchatsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchFamillesProduitsAchats requireOne(Long id) {
        return achFamillesProduitsAchatsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
