package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmParcDTO;
import com.yewi.yewicore.recuperation.service.CmmParcService;
import com.yewi.yewicore.recuperation.vo.CmmParcQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmParcUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmParcVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmParc")
public class CmmParcController {

    @Autowired
    private CmmParcService cmmParcService;

    @PostMapping
    public String save(@Valid @RequestBody CmmParcVO vO) {
        return cmmParcService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmParcService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmParcUpdateVO vO) {
        cmmParcService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmParcDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmParcService.getById(id);
    }

    @GetMapping
    public Page<CmmParcDTO> query(@Valid CmmParcQueryVO vO) {
        return cmmParcService.query(vO);
    }
}
