package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptEcrituresAnterieur;
import com.yewi.yewicore.recuperation.dtos.CptEcrituresAnterieurDTO;
import com.yewi.yewicore.recuperation.repository.CptEcrituresAnterieurRepository;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnterieurQueryVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnterieurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnterieurVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptEcrituresAnterieurService {

    @Autowired
    private CptEcrituresAnterieurRepository cptEcrituresAnterieurRepository;

    public Long save(CptEcrituresAnterieurVO vO) {
        CptEcrituresAnterieur bean = new CptEcrituresAnterieur();
        BeanUtils.copyProperties(vO, bean);
        bean = cptEcrituresAnterieurRepository.save(bean);
        return bean.getEcrantId();
    }

    public void delete(Long id) {
        cptEcrituresAnterieurRepository.deleteById(id);
    }

    public void update(Long id, CptEcrituresAnterieurUpdateVO vO) {
        CptEcrituresAnterieur bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptEcrituresAnterieurRepository.save(bean);
    }

    public CptEcrituresAnterieurDTO getById(Long id) {
        CptEcrituresAnterieur original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptEcrituresAnterieurDTO> query(CptEcrituresAnterieurQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptEcrituresAnterieurDTO toDTO(CptEcrituresAnterieur original) {
        CptEcrituresAnterieurDTO bean = new CptEcrituresAnterieurDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptEcrituresAnterieur requireOne(Long id) {
        return cptEcrituresAnterieurRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
