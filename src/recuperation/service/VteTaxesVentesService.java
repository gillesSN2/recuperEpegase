package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteTaxesVentes;
import com.yewi.yewicore.recuperation.dtos.VteTaxesVentesDTO;
import com.yewi.yewicore.recuperation.repository.VteTaxesVentesRepository;
import com.yewi.yewicore.recuperation.vo.VteTaxesVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteTaxesVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteTaxesVentesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteTaxesVentesService {

    @Autowired
    private VteTaxesVentesRepository vteTaxesVentesRepository;

    public Long save(VteTaxesVentesVO vO) {
        VteTaxesVentes bean = new VteTaxesVentes();
        BeanUtils.copyProperties(vO, bean);
        bean = vteTaxesVentesRepository.save(bean);
        return bean.getTaxvteId();
    }

    public void delete(Long id) {
        vteTaxesVentesRepository.deleteById(id);
    }

    public void update(Long id, VteTaxesVentesUpdateVO vO) {
        VteTaxesVentes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteTaxesVentesRepository.save(bean);
    }

    public VteTaxesVentesDTO getById(Long id) {
        VteTaxesVentes original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteTaxesVentesDTO> query(VteTaxesVentesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteTaxesVentesDTO toDTO(VteTaxesVentes original) {
        VteTaxesVentesDTO bean = new VteTaxesVentesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteTaxesVentes requireOne(Long id) {
        return vteTaxesVentesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
