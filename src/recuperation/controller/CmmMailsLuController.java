package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmMailsLuDTO;
import com.yewi.yewicore.recuperation.service.CmmMailsLuService;
import com.yewi.yewicore.recuperation.vo.CmmMailsLuQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsLuUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsLuVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmMailsLu")
public class CmmMailsLuController {

    @Autowired
    private CmmMailsLuService cmmMailsLuService;

    @PostMapping
    public String save(@Valid @RequestBody CmmMailsLuVO vO) {
        return cmmMailsLuService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmMailsLuService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmMailsLuUpdateVO vO) {
        cmmMailsLuService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmMailsLuDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmMailsLuService.getById(id);
    }

    @GetMapping
    public Page<CmmMailsLuDTO> query(@Valid CmmMailsLuQueryVO vO) {
        return cmmMailsLuService.query(vO);
    }
}
