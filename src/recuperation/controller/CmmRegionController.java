package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmRegionDTO;
import com.yewi.yewicore.recuperation.service.CmmRegionService;
import com.yewi.yewicore.recuperation.vo.CmmRegionQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmRegionUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmRegionVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmRegion")
public class CmmRegionController {

    @Autowired
    private CmmRegionService cmmRegionService;

    @PostMapping
    public String save(@Valid @RequestBody CmmRegionVO vO) {
        return cmmRegionService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmRegionService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmRegionUpdateVO vO) {
        cmmRegionService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmRegionDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmRegionService.getById(id);
    }

    @GetMapping
    public Page<CmmRegionDTO> query(@Valid CmmRegionQueryVO vO) {
        return cmmRegionService.query(vO);
    }
}
