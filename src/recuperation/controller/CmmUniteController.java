package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmUniteDTO;
import com.yewi.yewicore.recuperation.service.CmmUniteService;
import com.yewi.yewicore.recuperation.vo.CmmUniteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUniteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUniteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmUnite")
public class CmmUniteController {

    @Autowired
    private CmmUniteService cmmUniteService;

    @PostMapping
    public String save(@Valid @RequestBody CmmUniteVO vO) {
        return cmmUniteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmUniteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmUniteUpdateVO vO) {
        cmmUniteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmUniteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmUniteService.getById(id);
    }

    @GetMapping
    public Page<CmmUniteDTO> query(@Valid CmmUniteQueryVO vO) {
        return cmmUniteService.query(vO);
    }
}
