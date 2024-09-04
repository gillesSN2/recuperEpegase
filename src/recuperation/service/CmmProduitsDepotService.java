package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsDepot;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsDepotDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsDepotRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDepotQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDepotUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDepotVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsDepotService {

    @Autowired
    private CmmProduitsDepotRepository cmmProduitsDepotRepository;

    public Long save(CmmProduitsDepotVO vO) {
        CmmProduitsDepot bean = new CmmProduitsDepot();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsDepotRepository.save(bean);
        return bean.getProdepId();
    }

    public void delete(Long id) {
        cmmProduitsDepotRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsDepotUpdateVO vO) {
        CmmProduitsDepot bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsDepotRepository.save(bean);
    }

    public CmmProduitsDepotDTO getById(Long id) {
        CmmProduitsDepot original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsDepotDTO> query(CmmProduitsDepotQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsDepotDTO toDTO(CmmProduitsDepot original) {
        CmmProduitsDepotDTO bean = new CmmProduitsDepotDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsDepot requireOne(Long id) {
        return cmmProduitsDepotRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
