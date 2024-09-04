package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmMailsDTO;
import com.yewi.yewicore.recuperation.service.CmmMailsService;
import com.yewi.yewicore.recuperation.vo.CmmMailsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmMails")
public class CmmMailsController {

    @Autowired
    private CmmMailsService cmmMailsService;

    @PostMapping
    public String save(@Valid @RequestBody CmmMailsVO vO) {
        return cmmMailsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmMailsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmMailsUpdateVO vO) {
        cmmMailsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmMailsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmMailsService.getById(id);
    }

    @GetMapping
    public Page<CmmMailsDTO> query(@Valid CmmMailsQueryVO vO) {
        return cmmMailsService.query(vO);
    }
}
