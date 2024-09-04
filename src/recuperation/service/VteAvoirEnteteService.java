package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteAvoirEntete;
import com.yewi.yewicore.recuperation.dtos.VteAvoirEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteAvoirEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteAvoirEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteAvoirEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteAvoirEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteAvoirEnteteService {

    @Autowired
    private VteAvoirEnteteRepository vteAvoirEnteteRepository;

    public Long save(VteAvoirEnteteVO vO) {
        VteAvoirEntete bean = new VteAvoirEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteAvoirEnteteRepository.save(bean);
        return bean.getAvrId();
    }

    public void delete(Long id) {
        vteAvoirEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteAvoirEnteteUpdateVO vO) {
        VteAvoirEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteAvoirEnteteRepository.save(bean);
    }

    public VteAvoirEnteteDTO getById(Long id) {
        VteAvoirEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteAvoirEnteteDTO> query(VteAvoirEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteAvoirEnteteDTO toDTO(VteAvoirEntete original) {
        VteAvoirEnteteDTO bean = new VteAvoirEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteAvoirEntete requireOne(Long id) {
        return vteAvoirEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
