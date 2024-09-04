package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsMcles;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsMclesDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsMclesRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsMclesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsMclesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsMclesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsMclesService {

    @Autowired
    private CmmProduitsMclesRepository cmmProduitsMclesRepository;

    public Long save(CmmProduitsMclesVO vO) {
        CmmProduitsMcles bean = new CmmProduitsMcles();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsMclesRepository.save(bean);
        return bean.getPromclId();
    }

    public void delete(Long id) {
        cmmProduitsMclesRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsMclesUpdateVO vO) {
        CmmProduitsMcles bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsMclesRepository.save(bean);
    }

    public CmmProduitsMclesDTO getById(Long id) {
        CmmProduitsMcles original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsMclesDTO> query(CmmProduitsMclesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsMclesDTO toDTO(CmmProduitsMcles original) {
        CmmProduitsMclesDTO bean = new CmmProduitsMclesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsMcles requireOne(Long id) {
        return cmmProduitsMclesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
