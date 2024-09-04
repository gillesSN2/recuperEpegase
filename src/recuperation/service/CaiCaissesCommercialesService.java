package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiCaissesCommerciales;
import com.yewi.yewicore.recuperation.dtos.CaiCaissesCommercialesDTO;
import com.yewi.yewicore.recuperation.repository.CaiCaissesCommercialesRepository;
import com.yewi.yewicore.recuperation.vo.CaiCaissesCommercialesQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesCommercialesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesCommercialesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiCaissesCommercialesService {

    @Autowired
    private CaiCaissesCommercialesRepository caiCaissesCommercialesRepository;

    public Long save(CaiCaissesCommercialesVO vO) {
        CaiCaissesCommerciales bean = new CaiCaissesCommerciales();
        BeanUtils.copyProperties(vO, bean);
        bean = caiCaissesCommercialesRepository.save(bean);
        return bean.getCaiId();
    }

    public void delete(Long id) {
        caiCaissesCommercialesRepository.deleteById(id);
    }

    public void update(Long id, CaiCaissesCommercialesUpdateVO vO) {
        CaiCaissesCommerciales bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiCaissesCommercialesRepository.save(bean);
    }

    public CaiCaissesCommercialesDTO getById(Long id) {
        CaiCaissesCommerciales original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiCaissesCommercialesDTO> query(CaiCaissesCommercialesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiCaissesCommercialesDTO toDTO(CaiCaissesCommerciales original) {
        CaiCaissesCommercialesDTO bean = new CaiCaissesCommercialesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiCaissesCommerciales requireOne(Long id) {
        return caiCaissesCommercialesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
