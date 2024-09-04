package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmParapheurDTO;
import com.yewi.yewicore.recuperation.service.CmmParapheurService;
import com.yewi.yewicore.recuperation.vo.CmmParapheurQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmParapheurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmParapheurVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmParapheur")
public class CmmParapheurController {

    @Autowired
    private CmmParapheurService cmmParapheurService;

    @PostMapping
    public String save(@Valid @RequestBody CmmParapheurVO vO) {
        return cmmParapheurService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmParapheurService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmParapheurUpdateVO vO) {
        cmmParapheurService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmParapheurDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmParapheurService.getById(id);
    }

    @GetMapping
    public Page<CmmParapheurDTO> query(@Valid CmmParapheurQueryVO vO) {
        return cmmParapheurService.query(vO);
    }
}
