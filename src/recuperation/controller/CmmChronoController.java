package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmChronoDTO;
import com.yewi.yewicore.recuperation.service.CmmChronoService;
import com.yewi.yewicore.recuperation.vo.CmmChronoQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmChronoUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmChronoVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmChrono")
public class CmmChronoController {

    @Autowired
    private CmmChronoService cmmChronoService;

    @PostMapping
    public String save(@Valid @RequestBody CmmChronoVO vO) {
        return cmmChronoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmChronoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmChronoUpdateVO vO) {
        cmmChronoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmChronoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmChronoService.getById(id);
    }

    @GetMapping
    public Page<CmmChronoDTO> query(@Valid CmmChronoQueryVO vO) {
        return cmmChronoService.query(vO);
    }
}
