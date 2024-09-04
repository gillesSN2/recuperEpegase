package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteContratEntete;
import com.yewi.yewicore.recuperation.dtos.VteContratEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteContratEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteContratEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteContratEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteContratEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteContratEnteteService {

    @Autowired
    private VteContratEnteteRepository vteContratEnteteRepository;

    public Long save(VteContratEnteteVO vO) {
        VteContratEntete bean = new VteContratEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteContratEnteteRepository.save(bean);
        return bean.getCrtId();
    }

    public void delete(Long id) {
        vteContratEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteContratEnteteUpdateVO vO) {
        VteContratEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteContratEnteteRepository.save(bean);
    }

    public VteContratEnteteDTO getById(Long id) {
        VteContratEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteContratEnteteDTO> query(VteContratEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteContratEnteteDTO toDTO(VteContratEntete original) {
        VteContratEnteteDTO bean = new VteContratEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteContratEntete requireOne(Long id) {
        return vteContratEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
