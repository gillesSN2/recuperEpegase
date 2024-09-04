package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchBonEntreeEntete;
import com.yewi.yewicore.recuperation.dtos.AchBonEntreeEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchBonEntreeEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchBonEntreeEnteteService {

    @Autowired
    private AchBonEntreeEnteteRepository achBonEntreeEnteteRepository;

    public Long save(AchBonEntreeEnteteVO vO) {
        AchBonEntreeEntete bean = new AchBonEntreeEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achBonEntreeEnteteRepository.save(bean);
        return bean.getBinId();
    }

    public void delete(Long id) {
        achBonEntreeEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchBonEntreeEnteteUpdateVO vO) {
        AchBonEntreeEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achBonEntreeEnteteRepository.save(bean);
    }

    public AchBonEntreeEnteteDTO getById(Long id) {
        AchBonEntreeEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchBonEntreeEnteteDTO> query(AchBonEntreeEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchBonEntreeEnteteDTO toDTO(AchBonEntreeEntete original) {
        AchBonEntreeEnteteDTO bean = new AchBonEntreeEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchBonEntreeEntete requireOne(Long id) {
        return achBonEntreeEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
