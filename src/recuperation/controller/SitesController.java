package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.SitesDTO;
import com.yewi.yewicore.recuperation.service.SitesService;
import com.yewi.yewicore.recuperation.vo.SitesQueryVO;
import com.yewi.yewicore.recuperation.vo.SitesUpdateVO;
import com.yewi.yewicore.recuperation.vo.SitesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/sites")
public class SitesController {

    @Autowired
    private SitesService sitesService;

    @PostMapping
    public String save(@Valid @RequestBody SitesVO vO) {
        return sitesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        sitesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody SitesUpdateVO vO) {
        sitesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public SitesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return sitesService.getById(id);
    }

    @GetMapping
    public Page<SitesDTO> query(@Valid SitesQueryVO vO) {
        return sitesService.query(vO);
    }
}
