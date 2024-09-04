package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmScriptsDTO;
import com.yewi.yewicore.recuperation.service.CmmScriptsService;
import com.yewi.yewicore.recuperation.vo.CmmScriptsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmScriptsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmScriptsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmScripts")
public class CmmScriptsController {

    @Autowired
    private CmmScriptsService cmmScriptsService;

    @PostMapping
    public String save(@Valid @RequestBody CmmScriptsVO vO) {
        return cmmScriptsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmScriptsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmScriptsUpdateVO vO) {
        cmmScriptsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmScriptsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmScriptsService.getById(id);
    }

    @GetMapping
    public Page<CmmScriptsDTO> query(@Valid CmmScriptsQueryVO vO) {
        return cmmScriptsService.query(vO);
    }
}
