package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmUsers;
import com.yewi.yewicore.recuperation.dtos.CmmUsersDTO;
import com.yewi.yewicore.recuperation.repository.CmmUsersRepository;
import com.yewi.yewicore.recuperation.vo.CmmUsersQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmUsersService {

    @Autowired
    private CmmUsersRepository cmmUsersRepository;

    public Long save(CmmUsersVO vO) {
        CmmUsers bean = new CmmUsers();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmUsersRepository.save(bean);
        return bean.getUsrId();
    }

    public void delete(Long id) {
        cmmUsersRepository.deleteById(id);
    }

    public void update(Long id, CmmUsersUpdateVO vO) {
        CmmUsers bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmUsersRepository.save(bean);
    }

    public CmmUsersDTO getById(Long id) {
        CmmUsers original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmUsersDTO> query(CmmUsersQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmUsersDTO toDTO(CmmUsers original) {
        CmmUsersDTO bean = new CmmUsersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmUsers requireOne(Long id) {
        return cmmUsersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
