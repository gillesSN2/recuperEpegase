package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmGroupeChronoDTO;
import com.yewi.yewicore.recuperation.service.CmmGroupeChronoService;
import com.yewi.yewicore.recuperation.vo.CmmGroupeChronoQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeChronoUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeChronoVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmGroupeChrono")
public class CmmGroupeChronoController {

    @Autowired
    private CmmGroupeChronoService cmmGroupeChronoService;

    @PostMapping
    public String save(@Valid @RequestBody CmmGroupeChronoVO vO) {
        return cmmGroupeChronoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmGroupeChronoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmGroupeChronoUpdateVO vO) {
        cmmGroupeChronoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmGroupeChronoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmGroupeChronoService.getById(id);
    }

    @GetMapping
    public Page<CmmGroupeChronoDTO> query(@Valid CmmGroupeChronoQueryVO vO) {
        return cmmGroupeChronoService.query(vO);
    }
}
