package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchValorisationEntete;
import com.yewi.yewicore.recuperation.dtos.AchValorisationEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchValorisationEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchValorisationEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchValorisationEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchValorisationEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchValorisationEnteteService {

    @Autowired
    private AchValorisationEnteteRepository achValorisationEnteteRepository;

    public Long save(AchValorisationEnteteVO vO) {
        AchValorisationEntete bean = new AchValorisationEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achValorisationEnteteRepository.save(bean);
        return bean.getValId();
    }

    public void delete(Long id) {
        achValorisationEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchValorisationEnteteUpdateVO vO) {
        AchValorisationEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achValorisationEnteteRepository.save(bean);
    }

    public AchValorisationEnteteDTO getById(Long id) {
        AchValorisationEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchValorisationEnteteDTO> query(AchValorisationEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchValorisationEnteteDTO toDTO(AchValorisationEntete original) {
        AchValorisationEnteteDTO bean = new AchValorisationEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchValorisationEntete requireOne(Long id) {
        return achValorisationEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
