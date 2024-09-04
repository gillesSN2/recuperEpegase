package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteBonEncaissement;
import com.yewi.yewicore.recuperation.dtos.VteBonEncaissementDTO;
import com.yewi.yewicore.recuperation.repository.VteBonEncaissementRepository;
import com.yewi.yewicore.recuperation.vo.VteBonEncaissementQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBonEncaissementUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBonEncaissementVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteBonEncaissementService {

    @Autowired
    private VteBonEncaissementRepository vteBonEncaissementRepository;

    public Long save(VteBonEncaissementVO vO) {
        VteBonEncaissement bean = new VteBonEncaissement();
        BeanUtils.copyProperties(vO, bean);
        bean = vteBonEncaissementRepository.save(bean);
        return bean.getBonId();
    }

    public void delete(Long id) {
        vteBonEncaissementRepository.deleteById(id);
    }

    public void update(Long id, VteBonEncaissementUpdateVO vO) {
        VteBonEncaissement bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteBonEncaissementRepository.save(bean);
    }

    public VteBonEncaissementDTO getById(Long id) {
        VteBonEncaissement original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteBonEncaissementDTO> query(VteBonEncaissementQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteBonEncaissementDTO toDTO(VteBonEncaissement original) {
        VteBonEncaissementDTO bean = new VteBonEncaissementDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteBonEncaissement requireOne(Long id) {
        return vteBonEncaissementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
