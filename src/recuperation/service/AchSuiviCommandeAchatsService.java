package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchSuiviCommandeAchats;
import com.yewi.yewicore.recuperation.dtos.AchSuiviCommandeAchatsDTO;
import com.yewi.yewicore.recuperation.repository.AchSuiviCommandeAchatsRepository;
import com.yewi.yewicore.recuperation.vo.AchSuiviCommandeAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchSuiviCommandeAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchSuiviCommandeAchatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchSuiviCommandeAchatsService {

    @Autowired
    private AchSuiviCommandeAchatsRepository achSuiviCommandeAchatsRepository;

    public Long save(AchSuiviCommandeAchatsVO vO) {
        AchSuiviCommandeAchats bean = new AchSuiviCommandeAchats();
        BeanUtils.copyProperties(vO, bean);
        bean = achSuiviCommandeAchatsRepository.save(bean);
        return bean.getSuiachId();
    }

    public void delete(Long id) {
        achSuiviCommandeAchatsRepository.deleteById(id);
    }

    public void update(Long id, AchSuiviCommandeAchatsUpdateVO vO) {
        AchSuiviCommandeAchats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achSuiviCommandeAchatsRepository.save(bean);
    }

    public AchSuiviCommandeAchatsDTO getById(Long id) {
        AchSuiviCommandeAchats original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchSuiviCommandeAchatsDTO> query(AchSuiviCommandeAchatsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchSuiviCommandeAchatsDTO toDTO(AchSuiviCommandeAchats original) {
        AchSuiviCommandeAchatsDTO bean = new AchSuiviCommandeAchatsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchSuiviCommandeAchats requireOne(Long id) {
        return achSuiviCommandeAchatsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
