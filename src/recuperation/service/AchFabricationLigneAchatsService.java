package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchFabricationLigneAchats;
import com.yewi.yewicore.recuperation.dtos.AchFabricationLigneAchatsDTO;
import com.yewi.yewicore.recuperation.repository.AchFabricationLigneAchatsRepository;
import com.yewi.yewicore.recuperation.vo.AchFabricationLigneAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFabricationLigneAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFabricationLigneAchatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchFabricationLigneAchatsService {

    @Autowired
    private AchFabricationLigneAchatsRepository achFabricationLigneAchatsRepository;

    public Long save(AchFabricationLigneAchatsVO vO) {
        AchFabricationLigneAchats bean = new AchFabricationLigneAchats();
        BeanUtils.copyProperties(vO, bean);
        bean = achFabricationLigneAchatsRepository.save(bean);
        return bean.getFabligId();
    }

    public void delete(Long id) {
        achFabricationLigneAchatsRepository.deleteById(id);
    }

    public void update(Long id, AchFabricationLigneAchatsUpdateVO vO) {
        AchFabricationLigneAchats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achFabricationLigneAchatsRepository.save(bean);
    }

    public AchFabricationLigneAchatsDTO getById(Long id) {
        AchFabricationLigneAchats original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchFabricationLigneAchatsDTO> query(AchFabricationLigneAchatsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchFabricationLigneAchatsDTO toDTO(AchFabricationLigneAchats original) {
        AchFabricationLigneAchatsDTO bean = new AchFabricationLigneAchatsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchFabricationLigneAchats requireOne(Long id) {
        return achFabricationLigneAchatsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
