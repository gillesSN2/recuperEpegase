package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmHabilitationDTO;
import com.yewi.yewicore.recuperation.service.CmmHabilitationService;
import com.yewi.yewicore.recuperation.vo.CmmHabilitationQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmHabilitationUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmHabilitationVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmHabilitation")
public class CmmHabilitationController {

    @Autowired
    private CmmHabilitationService cmmHabilitationService;

    @PostMapping
    public String save(@Valid @RequestBody CmmHabilitationVO vO) {
        return cmmHabilitationService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmHabilitationService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmHabilitationUpdateVO vO) {
        cmmHabilitationService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmHabilitationDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmHabilitationService.getById(id);
    }

    @GetMapping
    public Page<CmmHabilitationDTO> query(@Valid CmmHabilitationQueryVO vO) {
        return cmmHabilitationService.query(vO);
    }
}
