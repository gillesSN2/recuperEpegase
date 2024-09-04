package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteFamillesProduitsVentes;
import com.yewi.yewicore.recuperation.dtos.VteFamillesProduitsVentesDTO;
import com.yewi.yewicore.recuperation.repository.VteFamillesProduitsVentesRepository;
import com.yewi.yewicore.recuperation.vo.VteFamillesProduitsVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteFamillesProduitsVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteFamillesProduitsVentesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteFamillesProduitsVentesService {

    @Autowired
    private VteFamillesProduitsVentesRepository vteFamillesProduitsVentesRepository;

    public Long save(VteFamillesProduitsVentesVO vO) {
        VteFamillesProduitsVentes bean = new VteFamillesProduitsVentes();
        BeanUtils.copyProperties(vO, bean);
        bean = vteFamillesProduitsVentesRepository.save(bean);
        return bean.getFamvteId();
    }

    public void delete(Long id) {
        vteFamillesProduitsVentesRepository.deleteById(id);
    }

    public void update(Long id, VteFamillesProduitsVentesUpdateVO vO) {
        VteFamillesProduitsVentes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteFamillesProduitsVentesRepository.save(bean);
    }

    public VteFamillesProduitsVentesDTO getById(Long id) {
        VteFamillesProduitsVentes original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteFamillesProduitsVentesDTO> query(VteFamillesProduitsVentesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteFamillesProduitsVentesDTO toDTO(VteFamillesProduitsVentes original) {
        VteFamillesProduitsVentesDTO bean = new VteFamillesProduitsVentesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteFamillesProduitsVentes requireOne(Long id) {
        return vteFamillesProduitsVentesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
