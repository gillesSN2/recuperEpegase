package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PrcParcAffectation;
import com.yewi.yewicore.recuperation.dtos.PrcParcAffectationDTO;
import com.yewi.yewicore.recuperation.repository.PrcParcAffectationRepository;
import com.yewi.yewicore.recuperation.vo.PrcParcAffectationQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcParcAffectationUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcParcAffectationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrcParcAffectationService {

    @Autowired
    private PrcParcAffectationRepository prcParcAffectationRepository;

    public Long save(PrcParcAffectationVO vO) {
        PrcParcAffectation bean = new PrcParcAffectation();
        BeanUtils.copyProperties(vO, bean);
        bean = prcParcAffectationRepository.save(bean);
        return bean.getPrcaffId();
    }

    public void delete(Long id) {
        prcParcAffectationRepository.deleteById(id);
    }

    public void update(Long id, PrcParcAffectationUpdateVO vO) {
        PrcParcAffectation bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        prcParcAffectationRepository.save(bean);
    }

    public PrcParcAffectationDTO getById(Long id) {
        PrcParcAffectation original = requireOne(id);
        return toDTO(original);
    }

    public Page<PrcParcAffectationDTO> query(PrcParcAffectationQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PrcParcAffectationDTO toDTO(PrcParcAffectation original) {
        PrcParcAffectationDTO bean = new PrcParcAffectationDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PrcParcAffectation requireOne(Long id) {
        return prcParcAffectationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
