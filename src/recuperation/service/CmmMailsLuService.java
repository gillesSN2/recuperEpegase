package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmMailsLu;
import com.yewi.yewicore.recuperation.dtos.CmmMailsLuDTO;
import com.yewi.yewicore.recuperation.repository.CmmMailsLuRepository;
import com.yewi.yewicore.recuperation.vo.CmmMailsLuQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsLuUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsLuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmMailsLuService {

    @Autowired
    private CmmMailsLuRepository cmmMailsLuRepository;

    public Long save(CmmMailsLuVO vO) {
        CmmMailsLu bean = new CmmMailsLu();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmMailsLuRepository.save(bean);
        return bean.getMailuId();
    }

    public void delete(Long id) {
        cmmMailsLuRepository.deleteById(id);
    }

    public void update(Long id, CmmMailsLuUpdateVO vO) {
        CmmMailsLu bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmMailsLuRepository.save(bean);
    }

    public CmmMailsLuDTO getById(Long id) {
        CmmMailsLu original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmMailsLuDTO> query(CmmMailsLuQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmMailsLuDTO toDTO(CmmMailsLu original) {
        CmmMailsLuDTO bean = new CmmMailsLuDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmMailsLu requireOne(Long id) {
        return cmmMailsLuRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
