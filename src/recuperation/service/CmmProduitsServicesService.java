package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsServices;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsServicesDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsServicesRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsServicesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsServicesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsServicesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsServicesService {

    @Autowired
    private CmmProduitsServicesRepository cmmProduitsServicesRepository;

    public Long save(CmmProduitsServicesVO vO) {
        CmmProduitsServices bean = new CmmProduitsServices();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsServicesRepository.save(bean);
        return bean.getProserId();
    }

    public void delete(Long id) {
        cmmProduitsServicesRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsServicesUpdateVO vO) {
        CmmProduitsServices bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsServicesRepository.save(bean);
    }

    public CmmProduitsServicesDTO getById(Long id) {
        CmmProduitsServices original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsServicesDTO> query(CmmProduitsServicesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsServicesDTO toDTO(CmmProduitsServices original) {
        CmmProduitsServicesDTO bean = new CmmProduitsServicesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsServices requireOne(Long id) {
        return cmmProduitsServicesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
