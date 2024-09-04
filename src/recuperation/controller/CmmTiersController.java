package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmTiersDTO;
import com.yewi.yewicore.recuperation.service.CmmTiersService;
import com.yewi.yewicore.recuperation.vo.CmmTiersQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmTiersUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmTiersVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmTiers")
public class CmmTiersController {

    @Autowired
    private CmmTiersService cmmTiersService;

    @PostMapping
    public String save(@Valid @RequestBody CmmTiersVO vO) {
        return cmmTiersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmTiersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmTiersUpdateVO vO) {
        cmmTiersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmTiersDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmTiersService.getById(id);
    }

    @GetMapping
    public Page<CmmTiersDTO> query(@Valid CmmTiersQueryVO vO) {
        return cmmTiersService.query(vO);
    }
}
