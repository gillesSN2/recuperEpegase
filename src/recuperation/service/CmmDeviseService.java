package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmDevise;
import com.yewi.yewicore.recuperation.dtos.CmmDeviseDTO;
import com.yewi.yewicore.recuperation.repository.CmmDeviseRepository;
import com.yewi.yewicore.recuperation.vo.CmmDeviseQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmDeviseUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmDeviseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmDeviseService {

    @Autowired
    private CmmDeviseRepository cmmDeviseRepository;

    public Integer save(CmmDeviseVO vO) {
        CmmDevise bean = new CmmDevise();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmDeviseRepository.save(bean);
        return bean.getDevId();
    }

    public void delete(Integer id) {
        cmmDeviseRepository.deleteById(id);
    }

    public void update(Integer id, CmmDeviseUpdateVO vO) {
        CmmDevise bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmDeviseRepository.save(bean);
    }

    public CmmDeviseDTO getById(Integer id) {
        CmmDevise original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmDeviseDTO> query(CmmDeviseQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmDeviseDTO toDTO(CmmDevise original) {
        CmmDeviseDTO bean = new CmmDeviseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmDevise requireOne(Integer id) {
        return cmmDeviseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
