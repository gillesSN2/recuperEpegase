package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiReglementsDTO;
import com.yewi.yewicore.recuperation.service.CaiReglementsService;
import com.yewi.yewicore.recuperation.vo.CaiReglementsQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiReglementsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiReglementsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiReglements")
public class CaiReglementsController {

    @Autowired
    private CaiReglementsService caiReglementsService;

    @PostMapping
    public String save(@Valid @RequestBody CaiReglementsVO vO) {
        return caiReglementsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiReglementsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiReglementsUpdateVO vO) {
        caiReglementsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiReglementsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiReglementsService.getById(id);
    }

    @GetMapping
    public Page<CaiReglementsDTO> query(@Valid CaiReglementsQueryVO vO) {
        return caiReglementsService.query(vO);
    }
}
