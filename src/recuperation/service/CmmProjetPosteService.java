package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProjetPoste;
import com.yewi.yewicore.recuperation.dtos.CmmProjetPosteDTO;
import com.yewi.yewicore.recuperation.repository.CmmProjetPosteRepository;
import com.yewi.yewicore.recuperation.vo.CmmProjetPosteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetPosteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetPosteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProjetPosteService {

    @Autowired
    private CmmProjetPosteRepository cmmProjetPosteRepository;

    public Long save(CmmProjetPosteVO vO) {
        CmmProjetPoste bean = new CmmProjetPoste();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProjetPosteRepository.save(bean);
        return bean.getProposId();
    }

    public void delete(Long id) {
        cmmProjetPosteRepository.deleteById(id);
    }

    public void update(Long id, CmmProjetPosteUpdateVO vO) {
        CmmProjetPoste bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProjetPosteRepository.save(bean);
    }

    public CmmProjetPosteDTO getById(Long id) {
        CmmProjetPoste original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProjetPosteDTO> query(CmmProjetPosteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProjetPosteDTO toDTO(CmmProjetPoste original) {
        CmmProjetPosteDTO bean = new CmmProjetPosteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProjetPoste requireOne(Long id) {
        return cmmProjetPosteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
