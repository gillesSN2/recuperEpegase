package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiCaissesOperations;
import com.yewi.yewicore.recuperation.dtos.CaiCaissesOperationsDTO;
import com.yewi.yewicore.recuperation.repository.CaiCaissesOperationsRepository;
import com.yewi.yewicore.recuperation.vo.CaiCaissesOperationsQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesOperationsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesOperationsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiCaissesOperationsService {

    @Autowired
    private CaiCaissesOperationsRepository caiCaissesOperationsRepository;

    public Long save(CaiCaissesOperationsVO vO) {
        CaiCaissesOperations bean = new CaiCaissesOperations();
        BeanUtils.copyProperties(vO, bean);
        bean = caiCaissesOperationsRepository.save(bean);
        return bean.getCaiopeId();
    }

    public void delete(Long id) {
        caiCaissesOperationsRepository.deleteById(id);
    }

    public void update(Long id, CaiCaissesOperationsUpdateVO vO) {
        CaiCaissesOperations bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiCaissesOperationsRepository.save(bean);
    }

    public CaiCaissesOperationsDTO getById(Long id) {
        CaiCaissesOperations original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiCaissesOperationsDTO> query(CaiCaissesOperationsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiCaissesOperationsDTO toDTO(CaiCaissesOperations original) {
        CaiCaissesOperationsDTO bean = new CaiCaissesOperationsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiCaissesOperations requireOne(Long id) {
        return caiCaissesOperationsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
