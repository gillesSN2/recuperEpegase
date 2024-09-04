package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmSecteurDTO;
import com.yewi.yewicore.recuperation.service.CmmSecteurService;
import com.yewi.yewicore.recuperation.vo.CmmSecteurQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmSecteurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmSecteurVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmSecteur")
public class CmmSecteurController {

    @Autowired
    private CmmSecteurService cmmSecteurService;

    @PostMapping
    public String save(@Valid @RequestBody CmmSecteurVO vO) {
        return cmmSecteurService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmSecteurService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmSecteurUpdateVO vO) {
        cmmSecteurService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmSecteurDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmSecteurService.getById(id);
    }

    @GetMapping
    public Page<CmmSecteurDTO> query(@Valid CmmSecteurQueryVO vO) {
        return cmmSecteurService.query(vO);
    }
}
