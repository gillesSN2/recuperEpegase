package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmCouleur;
import com.yewi.yewicore.recuperation.dtos.CmmCouleurDTO;
import com.yewi.yewicore.recuperation.repository.CmmCouleurRepository;
import com.yewi.yewicore.recuperation.vo.CmmCouleurQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmCouleurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmCouleurVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmCouleurService {

    @Autowired
    private CmmCouleurRepository cmmCouleurRepository;

    public Long save(CmmCouleurVO vO) {
        CmmCouleur bean = new CmmCouleur();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmCouleurRepository.save(bean);
        return bean.getCouId();
    }

    public void delete(Long id) {
        cmmCouleurRepository.deleteById(id);
    }

    public void update(Long id, CmmCouleurUpdateVO vO) {
        CmmCouleur bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmCouleurRepository.save(bean);
    }

    public CmmCouleurDTO getById(Long id) {
        CmmCouleur original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmCouleurDTO> query(CmmCouleurQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmCouleurDTO toDTO(CmmCouleur original) {
        CmmCouleurDTO bean = new CmmCouleurDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmCouleur requireOne(Long id) {
        return cmmCouleurRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
