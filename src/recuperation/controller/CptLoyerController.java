package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptLoyerDTO;
import com.yewi.yewicore.recuperation.service.CptLoyerService;
import com.yewi.yewicore.recuperation.vo.CptLoyerQueryVO;
import com.yewi.yewicore.recuperation.vo.CptLoyerUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptLoyerVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptLoyer")
public class CptLoyerController {

    @Autowired
    private CptLoyerService cptLoyerService;

    @PostMapping
    public String save(@Valid @RequestBody CptLoyerVO vO) {
        return cptLoyerService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptLoyerService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptLoyerUpdateVO vO) {
        cptLoyerService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptLoyerDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptLoyerService.getById(id);
    }

    @GetMapping
    public Page<CptLoyerDTO> query(@Valid CptLoyerQueryVO vO) {
        return cptLoyerService.query(vO);
    }
}
