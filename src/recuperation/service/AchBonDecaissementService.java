package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchBonDecaissement;
import com.yewi.yewicore.recuperation.dtos.AchBonDecaissementDTO;
import com.yewi.yewicore.recuperation.repository.AchBonDecaissementRepository;
import com.yewi.yewicore.recuperation.vo.AchBonDecaissementQueryVO;
import com.yewi.yewicore.recuperation.vo.AchBonDecaissementUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchBonDecaissementVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchBonDecaissementService {

    @Autowired
    private AchBonDecaissementRepository achBonDecaissementRepository;

    public Long save(AchBonDecaissementVO vO) {
        AchBonDecaissement bean = new AchBonDecaissement();
        BeanUtils.copyProperties(vO, bean);
        bean = achBonDecaissementRepository.save(bean);
        return bean.getBonId();
    }

    public void delete(Long id) {
        achBonDecaissementRepository.deleteById(id);
    }

    public void update(Long id, AchBonDecaissementUpdateVO vO) {
        AchBonDecaissement bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achBonDecaissementRepository.save(bean);
    }

    public AchBonDecaissementDTO getById(Long id) {
        AchBonDecaissement original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchBonDecaissementDTO> query(AchBonDecaissementQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchBonDecaissementDTO toDTO(AchBonDecaissement original) {
        AchBonDecaissementDTO bean = new AchBonDecaissementDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchBonDecaissement requireOne(Long id) {
        return achBonDecaissementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
