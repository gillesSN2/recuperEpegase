package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmSiteDTO;
import com.yewi.yewicore.recuperation.service.CmmSiteService;
import com.yewi.yewicore.recuperation.vo.CmmSiteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmSiteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmSiteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmSite")
public class CmmSiteController {

    @Autowired
    private CmmSiteService cmmSiteService;

    @PostMapping
    public String save(@Valid @RequestBody CmmSiteVO vO) {
        return cmmSiteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmSiteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmSiteUpdateVO vO) {
        cmmSiteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmSiteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmSiteService.getById(id);
    }

    @GetMapping
    public Page<CmmSiteDTO> query(@Valid CmmSiteQueryVO vO) {
        return cmmSiteService.query(vO);
    }
}
