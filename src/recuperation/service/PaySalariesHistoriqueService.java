package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesHistorique;
import com.yewi.yewicore.recuperation.dtos.PaySalariesHistoriqueDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesHistoriqueRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesHistoriqueQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesHistoriqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesHistoriqueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesHistoriqueService {

    @Autowired
    private PaySalariesHistoriqueRepository paySalariesHistoriqueRepository;

    public Long save(PaySalariesHistoriqueVO vO) {
        PaySalariesHistorique bean = new PaySalariesHistorique();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesHistoriqueRepository.save(bean);
        return bean.getSalhisId();
    }

    public void delete(Long id) {
        paySalariesHistoriqueRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesHistoriqueUpdateVO vO) {
        PaySalariesHistorique bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesHistoriqueRepository.save(bean);
    }

    public PaySalariesHistoriqueDTO getById(Long id) {
        PaySalariesHistorique original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesHistoriqueDTO> query(PaySalariesHistoriqueQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesHistoriqueDTO toDTO(PaySalariesHistorique original) {
        PaySalariesHistoriqueDTO bean = new PaySalariesHistoriqueDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesHistorique requireOne(Long id) {
        return paySalariesHistoriqueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
