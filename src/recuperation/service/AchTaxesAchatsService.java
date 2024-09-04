package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchTaxesAchats;
import com.yewi.yewicore.recuperation.dtos.AchTaxesAchatsDTO;
import com.yewi.yewicore.recuperation.repository.AchTaxesAchatsRepository;
import com.yewi.yewicore.recuperation.vo.AchTaxesAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchTaxesAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchTaxesAchatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchTaxesAchatsService {

    @Autowired
    private AchTaxesAchatsRepository achTaxesAchatsRepository;

    public Long save(AchTaxesAchatsVO vO) {
        AchTaxesAchats bean = new AchTaxesAchats();
        BeanUtils.copyProperties(vO, bean);
        bean = achTaxesAchatsRepository.save(bean);
        return bean.getTaxachId();
    }

    public void delete(Long id) {
        achTaxesAchatsRepository.deleteById(id);
    }

    public void update(Long id, AchTaxesAchatsUpdateVO vO) {
        AchTaxesAchats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achTaxesAchatsRepository.save(bean);
    }

    public AchTaxesAchatsDTO getById(Long id) {
        AchTaxesAchats original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchTaxesAchatsDTO> query(AchTaxesAchatsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchTaxesAchatsDTO toDTO(AchTaxesAchats original) {
        AchTaxesAchatsDTO bean = new AchTaxesAchatsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchTaxesAchats requireOne(Long id) {
        return achTaxesAchatsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
