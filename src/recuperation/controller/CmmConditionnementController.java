package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmConditionnementDTO;
import com.yewi.yewicore.recuperation.service.CmmConditionnementService;
import com.yewi.yewicore.recuperation.vo.CmmConditionnementQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmConditionnementUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmConditionnementVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmConditionnement")
public class CmmConditionnementController {

    @Autowired
    private CmmConditionnementService cmmConditionnementService;

    @PostMapping
    public String save(@Valid @RequestBody CmmConditionnementVO vO) {
        return cmmConditionnementService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmConditionnementService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmConditionnementUpdateVO vO) {
        cmmConditionnementService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmConditionnementDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmConditionnementService.getById(id);
    }

    @GetMapping
    public Page<CmmConditionnementDTO> query(@Valid CmmConditionnementQueryVO vO) {
        return cmmConditionnementService.query(vO);
    }
}
