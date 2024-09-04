package recuperation.service;

import com.yewi.yewicore.recuperation.domain.McfFamillesProduits;
import com.yewi.yewicore.recuperation.dtos.McfFamillesProduitsDTO;
import com.yewi.yewicore.recuperation.repository.McfFamillesProduitsRepository;
import com.yewi.yewicore.recuperation.vo.McfFamillesProduitsQueryVO;
import com.yewi.yewicore.recuperation.vo.McfFamillesProduitsUpdateVO;
import com.yewi.yewicore.recuperation.vo.McfFamillesProduitsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class McfFamillesProduitsService {

    @Autowired
    private McfFamillesProduitsRepository mcfFamillesProduitsRepository;

    public Long save(McfFamillesProduitsVO vO) {
        McfFamillesProduits bean = new McfFamillesProduits();
        BeanUtils.copyProperties(vO, bean);
        bean = mcfFamillesProduitsRepository.save(bean);
        return bean.getFammcfI();
    }

    public void delete(Long id) {
        mcfFamillesProduitsRepository.deleteById(id);
    }

    public void update(Long id, McfFamillesProduitsUpdateVO vO) {
        McfFamillesProduits bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        mcfFamillesProduitsRepository.save(bean);
    }

    public McfFamillesProduitsDTO getById(Long id) {
        McfFamillesProduits original = requireOne(id);
        return toDTO(original);
    }

    public Page<McfFamillesProduitsDTO> query(McfFamillesProduitsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private McfFamillesProduitsDTO toDTO(McfFamillesProduits original) {
        McfFamillesProduitsDTO bean = new McfFamillesProduitsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private McfFamillesProduits requireOne(Long id) {
        return mcfFamillesProduitsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
