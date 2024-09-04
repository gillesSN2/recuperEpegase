package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchBonSortieEntete;
import com.yewi.yewicore.recuperation.dtos.AchBonSortieEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchBonSortieEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchBonSortieEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchBonSortieEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchBonSortieEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchBonSortieEnteteService {

    @Autowired
    private AchBonSortieEnteteRepository achBonSortieEnteteRepository;

    public Long save(AchBonSortieEnteteVO vO) {
        AchBonSortieEntete bean = new AchBonSortieEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achBonSortieEnteteRepository.save(bean);
        return bean.getBouId();
    }

    public void delete(Long id) {
        achBonSortieEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchBonSortieEnteteUpdateVO vO) {
        AchBonSortieEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achBonSortieEnteteRepository.save(bean);
    }

    public AchBonSortieEnteteDTO getById(Long id) {
        AchBonSortieEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchBonSortieEnteteDTO> query(AchBonSortieEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchBonSortieEnteteDTO toDTO(AchBonSortieEntete original) {
        AchBonSortieEnteteDTO bean = new AchBonSortieEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchBonSortieEntete requireOne(Long id) {
        return achBonSortieEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
