package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProjetDTO;
import com.yewi.yewicore.recuperation.service.CmmProjetService;
import com.yewi.yewicore.recuperation.vo.CmmProjetQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProjet")
public class CmmProjetController {

    @Autowired
    private CmmProjetService cmmProjetService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProjetVO vO) {
        return cmmProjetService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProjetService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProjetUpdateVO vO) {
        cmmProjetService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProjetDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProjetService.getById(id);
    }

    @GetMapping
    public Page<CmmProjetDTO> query(@Valid CmmProjetQueryVO vO) {
        return cmmProjetService.query(vO);
    }
}
