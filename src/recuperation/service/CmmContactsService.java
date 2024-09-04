package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmContacts;
import com.yewi.yewicore.recuperation.dtos.CmmContactsDTO;
import com.yewi.yewicore.recuperation.repository.CmmContactsRepository;
import com.yewi.yewicore.recuperation.vo.CmmContactsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmContactsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmContactsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmContactsService {

    @Autowired
    private CmmContactsRepository cmmContactsRepository;

    public Long save(CmmContactsVO vO) {
        CmmContacts bean = new CmmContacts();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmContactsRepository.save(bean);
        return bean.getConId();
    }

    public void delete(Long id) {
        cmmContactsRepository.deleteById(id);
    }

    public void update(Long id, CmmContactsUpdateVO vO) {
        CmmContacts bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmContactsRepository.save(bean);
    }

    public CmmContactsDTO getById(Long id) {
        CmmContacts original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmContactsDTO> query(CmmContactsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmContactsDTO toDTO(CmmContacts original) {
        CmmContactsDTO bean = new CmmContactsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmContacts requireOne(Long id) {
        return cmmContactsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
