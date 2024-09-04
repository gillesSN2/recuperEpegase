package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiTraiteEnteteDTO;
import com.yewi.yewicore.recuperation.service.CaiTraiteEnteteService;
import com.yewi.yewicore.recuperation.vo.CaiTraiteEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiTraiteEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiTraiteEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiTraiteEntete")
public class CaiTraiteEnteteController {

    @Autowired
    private CaiTraiteEnteteService caiTraiteEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody CaiTraiteEnteteVO vO) {
        return caiTraiteEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiTraiteEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiTraiteEnteteUpdateVO vO) {
        caiTraiteEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiTraiteEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiTraiteEnteteService.getById(id);
    }

    @GetMapping
    public Page<CaiTraiteEnteteDTO> query(@Valid CaiTraiteEnteteQueryVO vO) {
        return caiTraiteEnteteService.query(vO);
    }
}
