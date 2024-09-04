package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsFourchette;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsFourchetteDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsFourchetteRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFourchetteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFourchetteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFourchetteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsFourchetteService {

    @Autowired
    private CmmProduitsFourchetteRepository cmmProduitsFourchetteRepository;

    public Long save(CmmProduitsFourchetteVO vO) {
        CmmProduitsFourchette bean = new CmmProduitsFourchette();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsFourchetteRepository.save(bean);
        return bean.getProfchId();
    }

    public void delete(Long id) {
        cmmProduitsFourchetteRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsFourchetteUpdateVO vO) {
        CmmProduitsFourchette bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsFourchetteRepository.save(bean);
    }

    public CmmProduitsFourchetteDTO getById(Long id) {
        CmmProduitsFourchette original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsFourchetteDTO> query(CmmProduitsFourchetteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsFourchetteDTO toDTO(CmmProduitsFourchette original) {
        CmmProduitsFourchetteDTO bean = new CmmProduitsFourchetteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsFourchette requireOne(Long id) {
        return cmmProduitsFourchetteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
