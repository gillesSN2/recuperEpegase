package recuperation.service;

import com.yewi.yewicore.recuperation.domain.UserFonctionnaliteDroit;
import com.yewi.yewicore.recuperation.dtos.UserFonctionnaliteDroitDTO;
import com.yewi.yewicore.recuperation.repository.UserFonctionnaliteDroitRepository;
import com.yewi.yewicore.recuperation.vo.UserFonctionnaliteDroitQueryVO;
import com.yewi.yewicore.recuperation.vo.UserFonctionnaliteDroitUpdateVO;
import com.yewi.yewicore.recuperation.vo.UserFonctionnaliteDroitVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserFonctionnaliteDroitService {

    @Autowired
    private UserFonctionnaliteDroitRepository userFonctionnaliteDroitRepository;

    public Long save(UserFonctionnaliteDroitVO vO) {
        UserFonctionnaliteDroit bean = new UserFonctionnaliteDroit();
        BeanUtils.copyProperties(vO, bean);
        bean = userFonctionnaliteDroitRepository.save(bean);
        return bean.getFonctionnaliteCode();
    }

    public void delete(Long id) {
        userFonctionnaliteDroitRepository.deleteById(id);
    }

    public void update(Long id, UserFonctionnaliteDroitUpdateVO vO) {
        UserFonctionnaliteDroit bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userFonctionnaliteDroitRepository.save(bean);
    }

    public UserFonctionnaliteDroitDTO getById(Long id) {
        UserFonctionnaliteDroit original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserFonctionnaliteDroitDTO> query(UserFonctionnaliteDroitQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserFonctionnaliteDroitDTO toDTO(UserFonctionnaliteDroit original) {
        UserFonctionnaliteDroitDTO bean = new UserFonctionnaliteDroitDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserFonctionnaliteDroit requireOne(Long id) {
        return userFonctionnaliteDroitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
