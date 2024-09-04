package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchDemandeEntete;
import com.yewi.yewicore.recuperation.dtos.AchDemandeEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchDemandeEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchDemandeEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchDemandeEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchDemandeEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchDemandeEnteteService {

    @Autowired
    private AchDemandeEnteteRepository achDemandeEnteteRepository;

    public Long save(AchDemandeEnteteVO vO) {
        AchDemandeEntete bean = new AchDemandeEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achDemandeEnteteRepository.save(bean);
        return bean.getDemId();
    }

    public void delete(Long id) {
        achDemandeEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchDemandeEnteteUpdateVO vO) {
        AchDemandeEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achDemandeEnteteRepository.save(bean);
    }

    public AchDemandeEnteteDTO getById(Long id) {
        AchDemandeEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchDemandeEnteteDTO> query(AchDemandeEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchDemandeEnteteDTO toDTO(AchDemandeEntete original) {
        AchDemandeEnteteDTO bean = new AchDemandeEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchDemandeEntete requireOne(Long id) {
        return achDemandeEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
