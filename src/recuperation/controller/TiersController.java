package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.TiersDTO;
import com.yewi.yewicore.recuperation.service.TiersService;
import com.yewi.yewicore.recuperation.vo.TiersQueryVO;
import com.yewi.yewicore.recuperation.vo.TiersUpdateVO;
import com.yewi.yewicore.recuperation.vo.TiersVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/tiers")
public class TiersController {

    @Autowired
    private TiersService tiersService;

    @PostMapping
    public String save(@Valid @RequestBody TiersVO vO) {
        return tiersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        tiersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TiersUpdateVO vO) {
        tiersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TiersDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return tiersService.getById(id);
    }

    @GetMapping
    public Page<TiersDTO> query(@Valid TiersQueryVO vO) {
        return tiersService.query(vO);
    }
}
