package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchFabricationEnteteAchats;
import com.yewi.yewicore.recuperation.dtos.AchFabricationEnteteAchatsDTO;
import com.yewi.yewicore.recuperation.repository.AchFabricationEnteteAchatsRepository;
import com.yewi.yewicore.recuperation.vo.AchFabricationEnteteAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFabricationEnteteAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFabricationEnteteAchatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchFabricationEnteteAchatsService {

    @Autowired
    private AchFabricationEnteteAchatsRepository achFabricationEnteteAchatsRepository;

    public Long save(AchFabricationEnteteAchatsVO vO) {
        AchFabricationEnteteAchats bean = new AchFabricationEnteteAchats();
        BeanUtils.copyProperties(vO, bean);
        bean = achFabricationEnteteAchatsRepository.save(bean);
        return bean.getFabId();
    }

    public void delete(Long id) {
        achFabricationEnteteAchatsRepository.deleteById(id);
    }

    public void update(Long id, AchFabricationEnteteAchatsUpdateVO vO) {
        AchFabricationEnteteAchats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achFabricationEnteteAchatsRepository.save(bean);
    }

    public AchFabricationEnteteAchatsDTO getById(Long id) {
        AchFabricationEnteteAchats original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchFabricationEnteteAchatsDTO> query(AchFabricationEnteteAchatsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchFabricationEnteteAchatsDTO toDTO(AchFabricationEnteteAchats original) {
        AchFabricationEnteteAchatsDTO bean = new AchFabricationEnteteAchatsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchFabricationEnteteAchats requireOne(Long id) {
        return achFabricationEnteteAchatsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
