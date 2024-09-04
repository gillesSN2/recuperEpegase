package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmUsersObjectifs;
import com.yewi.yewicore.recuperation.dtos.CmmUsersObjectifsDTO;
import com.yewi.yewicore.recuperation.repository.CmmUsersObjectifsRepository;
import com.yewi.yewicore.recuperation.vo.CmmUsersObjectifsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersObjectifsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersObjectifsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmUsersObjectifsService {

    @Autowired
    private CmmUsersObjectifsRepository cmmUsersObjectifsRepository;

    public Long save(CmmUsersObjectifsVO vO) {
        CmmUsersObjectifs bean = new CmmUsersObjectifs();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmUsersObjectifsRepository.save(bean);
        return bean.getUsrobjId();
    }

    public void delete(Long id) {
        cmmUsersObjectifsRepository.deleteById(id);
    }

    public void update(Long id, CmmUsersObjectifsUpdateVO vO) {
        CmmUsersObjectifs bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmUsersObjectifsRepository.save(bean);
    }

    public CmmUsersObjectifsDTO getById(Long id) {
        CmmUsersObjectifs original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmUsersObjectifsDTO> query(CmmUsersObjectifsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmUsersObjectifsDTO toDTO(CmmUsersObjectifs original) {
        CmmUsersObjectifsDTO bean = new CmmUsersObjectifsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmUsersObjectifs requireOne(Long id) {
        return cmmUsersObjectifsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
