package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsDetail;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsDetailDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsDetailRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDetailQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDetailUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsDetailService {

    @Autowired
    private CmmProduitsDetailRepository cmmProduitsDetailRepository;

    public Long save(CmmProduitsDetailVO vO) {
        CmmProduitsDetail bean = new CmmProduitsDetail();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsDetailRepository.save(bean);
        return bean.getProdetId();
    }

    public void delete(Long id) {
        cmmProduitsDetailRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsDetailUpdateVO vO) {
        CmmProduitsDetail bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsDetailRepository.save(bean);
    }

    public CmmProduitsDetailDTO getById(Long id) {
        CmmProduitsDetail original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsDetailDTO> query(CmmProduitsDetailQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsDetailDTO toDTO(CmmProduitsDetail original) {
        CmmProduitsDetailDTO bean = new CmmProduitsDetailDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsDetail requireOne(Long id) {
        return cmmProduitsDetailRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
