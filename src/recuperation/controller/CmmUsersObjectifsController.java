package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmUsersObjectifsDTO;
import com.yewi.yewicore.recuperation.service.CmmUsersObjectifsService;
import com.yewi.yewicore.recuperation.vo.CmmUsersObjectifsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersObjectifsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersObjectifsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmUsersObjectifs")
public class CmmUsersObjectifsController {

    @Autowired
    private CmmUsersObjectifsService cmmUsersObjectifsService;

    @PostMapping
    public String save(@Valid @RequestBody CmmUsersObjectifsVO vO) {
        return cmmUsersObjectifsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmUsersObjectifsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmUsersObjectifsUpdateVO vO) {
        cmmUsersObjectifsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmUsersObjectifsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmUsersObjectifsService.getById(id);
    }

    @GetMapping
    public Page<CmmUsersObjectifsDTO> query(@Valid CmmUsersObjectifsQueryVO vO) {
        return cmmUsersObjectifsService.query(vO);
    }
}
