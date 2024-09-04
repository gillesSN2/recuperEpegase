package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesConges;
import com.yewi.yewicore.recuperation.dtos.PaySalariesCongesDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesCongesRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesCongesQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesCongesUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesCongesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesCongesService {

    @Autowired
    private PaySalariesCongesRepository paySalariesCongesRepository;

    public Long save(PaySalariesCongesVO vO) {
        PaySalariesConges bean = new PaySalariesConges();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesCongesRepository.save(bean);
        return bean.getSalcngId();
    }

    public void delete(Long id) {
        paySalariesCongesRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesCongesUpdateVO vO) {
        PaySalariesConges bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesCongesRepository.save(bean);
    }

    public PaySalariesCongesDTO getById(Long id) {
        PaySalariesConges original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesCongesDTO> query(PaySalariesCongesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesCongesDTO toDTO(PaySalariesConges original) {
        PaySalariesCongesDTO bean = new PaySalariesCongesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesConges requireOne(Long id) {
        return paySalariesCongesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
