package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmScripts;
import com.yewi.yewicore.recuperation.dtos.CmmScriptsDTO;
import com.yewi.yewicore.recuperation.repository.CmmScriptsRepository;
import com.yewi.yewicore.recuperation.vo.CmmScriptsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmScriptsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmScriptsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmScriptsService {

    @Autowired
    private CmmScriptsRepository cmmScriptsRepository;

    public Long save(CmmScriptsVO vO) {
        CmmScripts bean = new CmmScripts();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmScriptsRepository.save(bean);
        return bean.getScrId();
    }

    public void delete(Long id) {
        cmmScriptsRepository.deleteById(id);
    }

    public void update(Long id, CmmScriptsUpdateVO vO) {
        CmmScripts bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmScriptsRepository.save(bean);
    }

    public CmmScriptsDTO getById(Long id) {
        CmmScripts original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmScriptsDTO> query(CmmScriptsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmScriptsDTO toDTO(CmmScripts original) {
        CmmScriptsDTO bean = new CmmScriptsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmScripts requireOne(Long id) {
        return cmmScriptsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
