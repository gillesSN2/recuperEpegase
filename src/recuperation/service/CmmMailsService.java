package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmMails;
import com.yewi.yewicore.recuperation.dtos.CmmMailsDTO;
import com.yewi.yewicore.recuperation.repository.CmmMailsRepository;
import com.yewi.yewicore.recuperation.vo.CmmMailsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmMailsService {

    @Autowired
    private CmmMailsRepository cmmMailsRepository;

    public Long save(CmmMailsVO vO) {
        CmmMails bean = new CmmMails();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmMailsRepository.save(bean);
        return bean.getMaiId();
    }

    public void delete(Long id) {
        cmmMailsRepository.deleteById(id);
    }

    public void update(Long id, CmmMailsUpdateVO vO) {
        CmmMails bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmMailsRepository.save(bean);
    }

    public CmmMailsDTO getById(Long id) {
        CmmMails original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmMailsDTO> query(CmmMailsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmMailsDTO toDTO(CmmMails original) {
        CmmMailsDTO bean = new CmmMailsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmMails requireOne(Long id) {
        return cmmMailsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
