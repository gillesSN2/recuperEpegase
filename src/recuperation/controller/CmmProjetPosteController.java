package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProjetPosteDTO;
import com.yewi.yewicore.recuperation.service.CmmProjetPosteService;
import com.yewi.yewicore.recuperation.vo.CmmProjetPosteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetPosteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProjetPosteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProjetPoste")
public class CmmProjetPosteController {

    @Autowired
    private CmmProjetPosteService cmmProjetPosteService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProjetPosteVO vO) {
        return cmmProjetPosteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProjetPosteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProjetPosteUpdateVO vO) {
        cmmProjetPosteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProjetPosteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProjetPosteService.getById(id);
    }

    @GetMapping
    public Page<CmmProjetPosteDTO> query(@Valid CmmProjetPosteQueryVO vO) {
        return cmmProjetPosteService.query(vO);
    }
}
