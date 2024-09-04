package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmActivitesDTO;
import com.yewi.yewicore.recuperation.service.CmmActivitesService;
import com.yewi.yewicore.recuperation.vo.CmmActivitesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmActivitesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmActivitesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmActivites")
public class CmmActivitesController {

    @Autowired
    private CmmActivitesService cmmActivitesService;

    @PostMapping
    public String save(@Valid @RequestBody CmmActivitesVO vO) {
        return cmmActivitesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmActivitesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmActivitesUpdateVO vO) {
        cmmActivitesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmActivitesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmActivitesService.getById(id);
    }

    @GetMapping
    public Page<CmmActivitesDTO> query(@Valid CmmActivitesQueryVO vO) {
        return cmmActivitesService.query(vO);
    }
}
