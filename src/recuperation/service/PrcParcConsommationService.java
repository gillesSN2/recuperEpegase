package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PrcParcConsommation;
import com.yewi.yewicore.recuperation.dtos.PrcParcConsommationDTO;
import com.yewi.yewicore.recuperation.repository.PrcParcConsommationRepository;
import com.yewi.yewicore.recuperation.vo.PrcParcConsommationQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcParcConsommationUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcParcConsommationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrcParcConsommationService {

    @Autowired
    private PrcParcConsommationRepository prcParcConsommationRepository;

    public Long save(PrcParcConsommationVO vO) {
        PrcParcConsommation bean = new PrcParcConsommation();
        BeanUtils.copyProperties(vO, bean);
        bean = prcParcConsommationRepository.save(bean);
        return bean.getPrcconId();
    }

    public void delete(Long id) {
        prcParcConsommationRepository.deleteById(id);
    }

    public void update(Long id, PrcParcConsommationUpdateVO vO) {
        PrcParcConsommation bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        prcParcConsommationRepository.save(bean);
    }

    public PrcParcConsommationDTO getById(Long id) {
        PrcParcConsommation original = requireOne(id);
        return toDTO(original);
    }

    public Page<PrcParcConsommationDTO> query(PrcParcConsommationQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PrcParcConsommationDTO toDTO(PrcParcConsommation original) {
        PrcParcConsommationDTO bean = new PrcParcConsommationDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PrcParcConsommation requireOne(Long id) {
        return prcParcConsommationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
