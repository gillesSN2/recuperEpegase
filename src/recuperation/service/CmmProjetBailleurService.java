package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProjetBailleur;
import com.yewi.yewicore.recuperation.dtos.CmmProjetBailleurDTO;
import com.yewi.yewicore.recuperation.repository.CmmProjetBailleurRepository;
import com.yewi.yewicore.recuperation.vo.CmmProjetBailleurQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetBailleurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetBailleurVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProjetBailleurService {

    @Autowired
    private CmmProjetBailleurRepository cmmProjetBailleurRepository;

    public Long save(CmmProjetBailleurVO vO) {
        CmmProjetBailleur bean = new CmmProjetBailleur();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProjetBailleurRepository.save(bean);
        return bean.getProbaiId();
    }

    public void delete(Long id) {
        cmmProjetBailleurRepository.deleteById(id);
    }

    public void update(Long id, CmmProjetBailleurUpdateVO vO) {
        CmmProjetBailleur bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProjetBailleurRepository.save(bean);
    }

    public CmmProjetBailleurDTO getById(Long id) {
        CmmProjetBailleur original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProjetBailleurDTO> query(CmmProjetBailleurQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProjetBailleurDTO toDTO(CmmProjetBailleur original) {
        CmmProjetBailleurDTO bean = new CmmProjetBailleurDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProjetBailleur requireOne(Long id) {
        return cmmProjetBailleurRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
