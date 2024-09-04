package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptBrouillardDTO;
import com.yewi.yewicore.recuperation.service.CptBrouillardService;
import com.yewi.yewicore.recuperation.vo.CptBrouillardQueryVO;
import com.yewi.yewicore.recuperation.vo.CptBrouillardUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptBrouillardVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptBrouillard")
public class CptBrouillardController {

    @Autowired
    private CptBrouillardService cptBrouillardService;

    @PostMapping
    public String save(@Valid @RequestBody CptBrouillardVO vO) {
        return cptBrouillardService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptBrouillardService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptBrouillardUpdateVO vO) {
        cptBrouillardService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptBrouillardDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptBrouillardService.getById(id);
    }

    @GetMapping
    public Page<CptBrouillardDTO> query(@Valid CptBrouillardQueryVO vO) {
        return cptBrouillardService.query(vO);
    }
}
