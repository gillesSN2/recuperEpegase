package recuperation.service;

import com.yewi.yewicore.recuperation.domain.GroupeFonctionnaliteDroit;
import com.yewi.yewicore.recuperation.dtos.GroupeFonctionnaliteDroitDTO;
import com.yewi.yewicore.recuperation.repository.GroupeFonctionnaliteDroitRepository;
import com.yewi.yewicore.recuperation.vo.GroupeFonctionnaliteDroitQueryVO;
import com.yewi.yewicore.recuperation.vo.GroupeFonctionnaliteDroitUpdateVO;
import com.yewi.yewicore.recuperation.vo.GroupeFonctionnaliteDroitVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GroupeFonctionnaliteDroitService {

    @Autowired
    private GroupeFonctionnaliteDroitRepository groupeFonctionnaliteDroitRepository;

    public Long save(GroupeFonctionnaliteDroitVO vO) {
        GroupeFonctionnaliteDroit bean = new GroupeFonctionnaliteDroit();
        BeanUtils.copyProperties(vO, bean);
        bean = groupeFonctionnaliteDroitRepository.save(bean);
        return bean.getCodeFonctionnalite();
    }

    public void delete(Long id) {
        groupeFonctionnaliteDroitRepository.deleteById(id);
    }

    public void update(Long id, GroupeFonctionnaliteDroitUpdateVO vO) {
        GroupeFonctionnaliteDroit bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        groupeFonctionnaliteDroitRepository.save(bean);
    }

    public GroupeFonctionnaliteDroitDTO getById(Long id) {
        GroupeFonctionnaliteDroit original = requireOne(id);
        return toDTO(original);
    }

    public Page<GroupeFonctionnaliteDroitDTO> query(GroupeFonctionnaliteDroitQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private GroupeFonctionnaliteDroitDTO toDTO(GroupeFonctionnaliteDroit original) {
        GroupeFonctionnaliteDroitDTO bean = new GroupeFonctionnaliteDroitDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private GroupeFonctionnaliteDroit requireOne(Long id) {
        return groupeFonctionnaliteDroitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
