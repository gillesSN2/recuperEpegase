package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CategoriesTiers;
import com.yewi.yewicore.recuperation.dtos.CategoriesTiersDTO;
import com.yewi.yewicore.recuperation.repository.CategoriesTiersRepository;
import com.yewi.yewicore.recuperation.vo.CategoriesTiersQueryVO;
import com.yewi.yewicore.recuperation.vo.CategoriesTiersUpdateVO;
import com.yewi.yewicore.recuperation.vo.CategoriesTiersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CategoriesTiersService {

    @Autowired
    private CategoriesTiersRepository categoriesTiersRepository;

    public Long save(CategoriesTiersVO vO) {
        CategoriesTiers bean = new CategoriesTiers();
        BeanUtils.copyProperties(vO, bean);
        bean = categoriesTiersRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        categoriesTiersRepository.deleteById(id);
    }

    public void update(Long id, CategoriesTiersUpdateVO vO) {
        CategoriesTiers bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        categoriesTiersRepository.save(bean);
    }

    public CategoriesTiersDTO getById(Long id) {
        CategoriesTiers original = requireOne(id);
        return toDTO(original);
    }

    public Page<CategoriesTiersDTO> query(CategoriesTiersQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CategoriesTiersDTO toDTO(CategoriesTiers original) {
        CategoriesTiersDTO bean = new CategoriesTiersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CategoriesTiers requireOne(Long id) {
        return categoriesTiersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
