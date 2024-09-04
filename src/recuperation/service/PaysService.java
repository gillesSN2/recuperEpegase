package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Pays;
import com.yewi.yewicore.recuperation.dtos.PaysDTO;
import com.yewi.yewicore.recuperation.repository.PaysRepository;
import com.yewi.yewicore.recuperation.vo.PaysQueryVO;
import com.yewi.yewicore.recuperation.vo.PaysUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaysVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaysService {

    @Autowired
    private PaysRepository paysRepository;

    public String save(PaysVO vO) {
        Pays bean = new Pays();
        BeanUtils.copyProperties(vO, bean);
        bean = paysRepository.save(bean);
        return bean.getCode();
    }

    public void delete(String id) {
        paysRepository.deleteById(id);
    }

    public void update(String id, PaysUpdateVO vO) {
        Pays bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paysRepository.save(bean);
    }

    public PaysDTO getById(String id) {
        Pays original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaysDTO> query(PaysQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaysDTO toDTO(Pays original) {
        PaysDTO bean = new PaysDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Pays requireOne(String id) {
        return paysRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
