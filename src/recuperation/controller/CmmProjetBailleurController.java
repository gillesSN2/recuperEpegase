package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProjetBailleurDTO;
import com.yewi.yewicore.recuperation.service.CmmProjetBailleurService;
import com.yewi.yewicore.recuperation.vo.CmmProjetBailleurQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetBailleurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetBailleurVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProjetBailleur")
public class CmmProjetBailleurController {

    @Autowired
    private CmmProjetBailleurService cmmProjetBailleurService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProjetBailleurVO vO) {
        return cmmProjetBailleurService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProjetBailleurService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProjetBailleurUpdateVO vO) {
        cmmProjetBailleurService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProjetBailleurDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProjetBailleurService.getById(id);
    }

    @GetMapping
    public Page<CmmProjetBailleurDTO> query(@Valid CmmProjetBailleurQueryVO vO) {
        return cmmProjetBailleurService.query(vO);
    }
}
