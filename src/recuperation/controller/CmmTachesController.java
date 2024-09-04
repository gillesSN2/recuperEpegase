package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmTachesDTO;
import com.yewi.yewicore.recuperation.service.CmmTachesService;
import com.yewi.yewicore.recuperation.vo.CmmTachesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmTachesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmTachesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmTaches")
public class CmmTachesController {

    @Autowired
    private CmmTachesService cmmTachesService;

    @PostMapping
    public String save(@Valid @RequestBody CmmTachesVO vO) {
        return cmmTachesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmTachesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmTachesUpdateVO vO) {
        cmmTachesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmTachesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmTachesService.getById(id);
    }

    @GetMapping
    public Page<CmmTachesDTO> query(@Valid CmmTachesQueryVO vO) {
        return cmmTachesService.query(vO);
    }
}
