package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmSecteur;
import com.yewi.yewicore.recuperation.dtos.CmmSecteurDTO;
import com.yewi.yewicore.recuperation.repository.CmmSecteurRepository;
import com.yewi.yewicore.recuperation.vo.CmmSecteurQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmSecteurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmSecteurVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmSecteurService {

    @Autowired
    private CmmSecteurRepository cmmSecteurRepository;

    public Long save(CmmSecteurVO vO) {
        CmmSecteur bean = new CmmSecteur();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmSecteurRepository.save(bean);
        return bean.getSecId();
    }

    public void delete(Long id) {
        cmmSecteurRepository.deleteById(id);
    }

    public void update(Long id, CmmSecteurUpdateVO vO) {
        CmmSecteur bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmSecteurRepository.save(bean);
    }

    public CmmSecteurDTO getById(Long id) {
        CmmSecteur original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmSecteurDTO> query(CmmSecteurQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmSecteurDTO toDTO(CmmSecteur original) {
        CmmSecteurDTO bean = new CmmSecteurDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmSecteur requireOne(Long id) {
        return cmmSecteurRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
