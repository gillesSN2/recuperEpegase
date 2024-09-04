package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PrcCaracteristique;
import com.yewi.yewicore.recuperation.dtos.PrcCaracteristiqueDTO;
import com.yewi.yewicore.recuperation.repository.PrcCaracteristiqueRepository;
import com.yewi.yewicore.recuperation.vo.PrcCaracteristiqueQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcCaracteristiqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcCaracteristiqueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrcCaracteristiqueService {

    @Autowired
    private PrcCaracteristiqueRepository prcCaracteristiqueRepository;

    public Long save(PrcCaracteristiqueVO vO) {
        PrcCaracteristique bean = new PrcCaracteristique();
        BeanUtils.copyProperties(vO, bean);
        bean = prcCaracteristiqueRepository.save(bean);
        return bean.getCarId();
    }

    public void delete(Long id) {
        prcCaracteristiqueRepository.deleteById(id);
    }

    public void update(Long id, PrcCaracteristiqueUpdateVO vO) {
        PrcCaracteristique bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        prcCaracteristiqueRepository.save(bean);
    }

    public PrcCaracteristiqueDTO getById(Long id) {
        PrcCaracteristique original = requireOne(id);
        return toDTO(original);
    }

    public Page<PrcCaracteristiqueDTO> query(PrcCaracteristiqueQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PrcCaracteristiqueDTO toDTO(PrcCaracteristique original) {
        PrcCaracteristiqueDTO bean = new PrcCaracteristiqueDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PrcCaracteristique requireOne(Long id) {
        return prcCaracteristiqueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
