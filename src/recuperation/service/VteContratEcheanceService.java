package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteContratEcheance;
import com.yewi.yewicore.recuperation.dtos.VteContratEcheanceDTO;
import com.yewi.yewicore.recuperation.repository.VteContratEcheanceRepository;
import com.yewi.yewicore.recuperation.vo.VteContratEcheanceQueryVO;
import com.yewi.yewicore.recuperation.vo.VteContratEcheanceUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteContratEcheanceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteContratEcheanceService {

    @Autowired
    private VteContratEcheanceRepository vteContratEcheanceRepository;

    public Long save(VteContratEcheanceVO vO) {
        VteContratEcheance bean = new VteContratEcheance();
        BeanUtils.copyProperties(vO, bean);
        bean = vteContratEcheanceRepository.save(bean);
        return bean.getCrtechId();
    }

    public void delete(Long id) {
        vteContratEcheanceRepository.deleteById(id);
    }

    public void update(Long id, VteContratEcheanceUpdateVO vO) {
        VteContratEcheance bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteContratEcheanceRepository.save(bean);
    }

    public VteContratEcheanceDTO getById(Long id) {
        VteContratEcheance original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteContratEcheanceDTO> query(VteContratEcheanceQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteContratEcheanceDTO toDTO(VteContratEcheance original) {
        VteContratEcheanceDTO bean = new VteContratEcheanceDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteContratEcheance requireOne(Long id) {
        return vteContratEcheanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
