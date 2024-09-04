package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsActe;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsActeDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsActeRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsActeQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsActeUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsActeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsActeService {

    @Autowired
    private CmmProduitsActeRepository cmmProduitsActeRepository;

    public Long save(CmmProduitsActeVO vO) {
        CmmProduitsActe bean = new CmmProduitsActe();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsActeRepository.save(bean);
        return bean.getProactId();
    }

    public void delete(Long id) {
        cmmProduitsActeRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsActeUpdateVO vO) {
        CmmProduitsActe bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsActeRepository.save(bean);
    }

    public CmmProduitsActeDTO getById(Long id) {
        CmmProduitsActe original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsActeDTO> query(CmmProduitsActeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsActeDTO toDTO(CmmProduitsActe original) {
        CmmProduitsActeDTO bean = new CmmProduitsActeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsActe requireOne(Long id) {
        return cmmProduitsActeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
