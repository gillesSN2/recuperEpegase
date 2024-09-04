package recuperation.service;

import com.yewi.yewicore.recuperation.domain.McfDossier;
import com.yewi.yewicore.recuperation.dtos.McfDossierDTO;
import com.yewi.yewicore.recuperation.repository.McfDossierRepository;
import com.yewi.yewicore.recuperation.vo.McfDossierQueryVO;
import com.yewi.yewicore.recuperation.vo.McfDossierUpdateVO;
import com.yewi.yewicore.recuperation.vo.McfDossierVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class McfDossierService {

    @Autowired
    private McfDossierRepository mcfDossierRepository;

    public Long save(McfDossierVO vO) {
        McfDossier bean = new McfDossier();
        BeanUtils.copyProperties(vO, bean);
        bean = mcfDossierRepository.save(bean);
        return bean.getDosId();
    }

    public void delete(Long id) {
        mcfDossierRepository.deleteById(id);
    }

    public void update(Long id, McfDossierUpdateVO vO) {
        McfDossier bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        mcfDossierRepository.save(bean);
    }

    public McfDossierDTO getById(Long id) {
        McfDossier original = requireOne(id);
        return toDTO(original);
    }

    public Page<McfDossierDTO> query(McfDossierQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private McfDossierDTO toDTO(McfDossier original) {
        McfDossierDTO bean = new McfDossierDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private McfDossier requireOne(Long id) {
        return mcfDossierRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
