package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptAmortissementsTab;
import com.yewi.yewicore.recuperation.dtos.CptAmortissementsTabDTO;
import com.yewi.yewicore.recuperation.repository.CptAmortissementsTabRepository;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsTabQueryVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsTabUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsTabVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptAmortissementsTabService {

    @Autowired
    private CptAmortissementsTabRepository cptAmortissementsTabRepository;

    public Long save(CptAmortissementsTabVO vO) {
        CptAmortissementsTab bean = new CptAmortissementsTab();
        BeanUtils.copyProperties(vO, bean);
        bean = cptAmortissementsTabRepository.save(bean);
        return bean.getAmotabId();
    }

    public void delete(Long id) {
        cptAmortissementsTabRepository.deleteById(id);
    }

    public void update(Long id, CptAmortissementsTabUpdateVO vO) {
        CptAmortissementsTab bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptAmortissementsTabRepository.save(bean);
    }

    public CptAmortissementsTabDTO getById(Long id) {
        CptAmortissementsTab original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptAmortissementsTabDTO> query(CptAmortissementsTabQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptAmortissementsTabDTO toDTO(CptAmortissementsTab original) {
        CptAmortissementsTabDTO bean = new CptAmortissementsTabDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptAmortissementsTab requireOne(Long id) {
        return cptAmortissementsTabRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
