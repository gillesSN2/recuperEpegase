package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteCommissionEntete;
import com.yewi.yewicore.recuperation.dtos.VteCommissionEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteCommissionEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteCommissionEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteCommissionEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteCommissionEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteCommissionEnteteService {

    @Autowired
    private VteCommissionEnteteRepository vteCommissionEnteteRepository;

    public Long save(VteCommissionEnteteVO vO) {
        VteCommissionEntete bean = new VteCommissionEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteCommissionEnteteRepository.save(bean);
        return bean.getComId();
    }

    public void delete(Long id) {
        vteCommissionEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteCommissionEnteteUpdateVO vO) {
        VteCommissionEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteCommissionEnteteRepository.save(bean);
    }

    public VteCommissionEnteteDTO getById(Long id) {
        VteCommissionEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteCommissionEnteteDTO> query(VteCommissionEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteCommissionEnteteDTO toDTO(VteCommissionEntete original) {
        VteCommissionEnteteDTO bean = new VteCommissionEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteCommissionEntete requireOne(Long id) {
        return vteCommissionEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
