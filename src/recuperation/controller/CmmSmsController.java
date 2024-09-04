package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmSmsDTO;
import com.yewi.yewicore.recuperation.service.CmmSmsService;
import com.yewi.yewicore.recuperation.vo.CmmSmsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmSmsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmSmsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmSms")
public class CmmSmsController {

    @Autowired
    private CmmSmsService cmmSmsService;

    @PostMapping
    public String save(@Valid @RequestBody CmmSmsVO vO) {
        return cmmSmsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmSmsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmSmsUpdateVO vO) {
        cmmSmsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmSmsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmSmsService.getById(id);
    }

    @GetMapping
    public Page<CmmSmsDTO> query(@Valid CmmSmsQueryVO vO) {
        return cmmSmsService.query(vO);
    }
}
