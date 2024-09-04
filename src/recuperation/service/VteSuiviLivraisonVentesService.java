package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteSuiviLivraisonVentes;
import com.yewi.yewicore.recuperation.dtos.VteSuiviLivraisonVentesDTO;
import com.yewi.yewicore.recuperation.repository.VteSuiviLivraisonVentesRepository;
import com.yewi.yewicore.recuperation.vo.VteSuiviLivraisonVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteSuiviLivraisonVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteSuiviLivraisonVentesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteSuiviLivraisonVentesService {

    @Autowired
    private VteSuiviLivraisonVentesRepository vteSuiviLivraisonVentesRepository;

    public Long save(VteSuiviLivraisonVentesVO vO) {
        VteSuiviLivraisonVentes bean = new VteSuiviLivraisonVentes();
        BeanUtils.copyProperties(vO, bean);
        bean = vteSuiviLivraisonVentesRepository.save(bean);
        return bean.getSuivteId();
    }

    public void delete(Long id) {
        vteSuiviLivraisonVentesRepository.deleteById(id);
    }

    public void update(Long id, VteSuiviLivraisonVentesUpdateVO vO) {
        VteSuiviLivraisonVentes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteSuiviLivraisonVentesRepository.save(bean);
    }

    public VteSuiviLivraisonVentesDTO getById(Long id) {
        VteSuiviLivraisonVentes original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteSuiviLivraisonVentesDTO> query(VteSuiviLivraisonVentesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteSuiviLivraisonVentesDTO toDTO(VteSuiviLivraisonVentes original) {
        VteSuiviLivraisonVentesDTO bean = new VteSuiviLivraisonVentesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteSuiviLivraisonVentes requireOne(Long id) {
        return vteSuiviLivraisonVentesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
