package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmResponsableDTO;
import com.yewi.yewicore.recuperation.service.CmmResponsableService;
import com.yewi.yewicore.recuperation.vo.CmmResponsableQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmResponsableUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmResponsableVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmResponsable")
public class CmmResponsableController {

    @Autowired
    private CmmResponsableService cmmResponsableService;

    @PostMapping
    public String save(@Valid @RequestBody CmmResponsableVO vO) {
        return cmmResponsableService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmResponsableService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmResponsableUpdateVO vO) {
        cmmResponsableService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmResponsableDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmResponsableService.getById(id);
    }

    @GetMapping
    public Page<CmmResponsableDTO> query(@Valid CmmResponsableQueryVO vO) {
        return cmmResponsableService.query(vO);
    }
}
