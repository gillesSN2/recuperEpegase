package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PrcParcCaracteristique;
import com.yewi.yewicore.recuperation.dtos.PrcParcCaracteristiqueDTO;
import com.yewi.yewicore.recuperation.repository.PrcParcCaracteristiqueRepository;
import com.yewi.yewicore.recuperation.vo.PrcParcCaracteristiqueQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcParcCaracteristiqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcParcCaracteristiqueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrcParcCaracteristiqueService {

    @Autowired
    private PrcParcCaracteristiqueRepository prcParcCaracteristiqueRepository;

    public Long save(PrcParcCaracteristiqueVO vO) {
        PrcParcCaracteristique bean = new PrcParcCaracteristique();
        BeanUtils.copyProperties(vO, bean);
        bean = prcParcCaracteristiqueRepository.save(bean);
        return bean.getPrccarId();
    }

    public void delete(Long id) {
        prcParcCaracteristiqueRepository.deleteById(id);
    }

    public void update(Long id, PrcParcCaracteristiqueUpdateVO vO) {
        PrcParcCaracteristique bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        prcParcCaracteristiqueRepository.save(bean);
    }

    public PrcParcCaracteristiqueDTO getById(Long id) {
        PrcParcCaracteristique original = requireOne(id);
        return toDTO(original);
    }

    public Page<PrcParcCaracteristiqueDTO> query(PrcParcCaracteristiqueQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PrcParcCaracteristiqueDTO toDTO(PrcParcCaracteristique original) {
        PrcParcCaracteristiqueDTO bean = new PrcParcCaracteristiqueDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PrcParcCaracteristique requireOne(Long id) {
        return prcParcCaracteristiqueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
