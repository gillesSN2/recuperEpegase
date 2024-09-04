package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PrcFamillesParc2;
import com.yewi.yewicore.recuperation.dtos.PrcFamillesParc2DTO;
import com.yewi.yewicore.recuperation.repository.PrcFamillesParc2Repository;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc2QueryVO;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc2UpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcFamillesParc2VO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrcFamillesParc2Service {

    @Autowired
    private PrcFamillesParc2Repository prcFamillesParc2Repository;

    public Long save(PrcFamillesParc2VO vO) {
        PrcFamillesParc2 bean = new PrcFamillesParc2();
        BeanUtils.copyProperties(vO, bean);
        bean = prcFamillesParc2Repository.save(bean);
        return bean.getFamprc2Id();
    }

    public void delete(Long id) {
        prcFamillesParc2Repository.deleteById(id);
    }

    public void update(Long id, PrcFamillesParc2UpdateVO vO) {
        PrcFamillesParc2 bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        prcFamillesParc2Repository.save(bean);
    }

    public PrcFamillesParc2DTO getById(Long id) {
        PrcFamillesParc2 original = requireOne(id);
        return toDTO(original);
    }

    public Page<PrcFamillesParc2DTO> query(PrcFamillesParc2QueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PrcFamillesParc2DTO toDTO(PrcFamillesParc2 original) {
        PrcFamillesParc2DTO bean = new PrcFamillesParc2DTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PrcFamillesParc2 requireOne(Long id) {
        return prcFamillesParc2Repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
