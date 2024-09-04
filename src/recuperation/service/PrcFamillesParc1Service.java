package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PrcFamillesParc1;
import com.yewi.yewicore.recuperation.dtos.PrcFamillesParc1DTO;
import com.yewi.yewicore.recuperation.repository.PrcFamillesParc1Repository;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc1QueryVO;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc1UpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc1VO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrcFamillesParc1Service {

    @Autowired
    private PrcFamillesParc1Repository prcFamillesParc1Repository;

    public Long save(PrcFamillesParc1VO vO) {
        PrcFamillesParc1 bean = new PrcFamillesParc1();
        BeanUtils.copyProperties(vO, bean);
        bean = prcFamillesParc1Repository.save(bean);
        return bean.getFamprc1Id();
    }

    public void delete(Long id) {
        prcFamillesParc1Repository.deleteById(id);
    }

    public void update(Long id, PrcFamillesParc1UpdateVO vO) {
        PrcFamillesParc1 bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        prcFamillesParc1Repository.save(bean);
    }

    public PrcFamillesParc1DTO getById(Long id) {
        PrcFamillesParc1 original = requireOne(id);
        return toDTO(original);
    }

    public Page<PrcFamillesParc1DTO> query(PrcFamillesParc1QueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PrcFamillesParc1DTO toDTO(PrcFamillesParc1 original) {
        PrcFamillesParc1DTO bean = new PrcFamillesParc1DTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PrcFamillesParc1 requireOne(Long id) {
        return prcFamillesParc1Repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
