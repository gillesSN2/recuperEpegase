package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmGroupe;
import com.yewi.yewicore.recuperation.dtos.CmmGroupeDTO;
import com.yewi.yewicore.recuperation.repository.CmmGroupeRepository;
import com.yewi.yewicore.recuperation.vo.CmmGroupeQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmGroupeService {

    @Autowired
    private CmmGroupeRepository cmmGroupeRepository;

    public Long save(CmmGroupeVO vO) {
        CmmGroupe bean = new CmmGroupe();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmGroupeRepository.save(bean);
        return bean.getGrpId();
    }

    public void delete(Long id) {
        cmmGroupeRepository.deleteById(id);
    }

    public void update(Long id, CmmGroupeUpdateVO vO) {
        CmmGroupe bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmGroupeRepository.save(bean);
    }

    public CmmGroupeDTO getById(Long id) {
        CmmGroupe original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmGroupeDTO> query(CmmGroupeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmGroupeDTO toDTO(CmmGroupe original) {
        CmmGroupeDTO bean = new CmmGroupeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmGroupe requireOne(Long id) {
        return cmmGroupeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
