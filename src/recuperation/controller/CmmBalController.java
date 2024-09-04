package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmBalDTO;
import com.yewi.yewicore.recuperation.service.CmmBalService;
import com.yewi.yewicore.recuperation.vo.CmmBalQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmBalUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmBalVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmBal")
public class CmmBalController {

    @Autowired
    private CmmBalService cmmBalService;

    @PostMapping
    public String save(@Valid @RequestBody CmmBalVO vO) {
        return cmmBalService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmBalService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmBalUpdateVO vO) {
        cmmBalService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmBalDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmBalService.getById(id);
    }

    @GetMapping
    public Page<CmmBalDTO> query(@Valid CmmBalQueryVO vO) {
        return cmmBalService.query(vO);
    }
}
