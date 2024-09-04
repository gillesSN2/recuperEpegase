package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.ImmBienGeranceEnteteDTO;
import com.yewi.yewicore.recuperation.service.ImmBienGeranceEnteteService;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/immBienGeranceEntete")
public class ImmBienGeranceEnteteController {

    @Autowired
    private ImmBienGeranceEnteteService immBienGeranceEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody ImmBienGeranceEnteteVO vO) {
        return immBienGeranceEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        immBienGeranceEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ImmBienGeranceEnteteUpdateVO vO) {
        immBienGeranceEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ImmBienGeranceEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return immBienGeranceEnteteService.getById(id);
    }

    @GetMapping
    public Page<ImmBienGeranceEnteteDTO> query(@Valid ImmBienGeranceEnteteQueryVO vO) {
        return immBienGeranceEnteteService.query(vO);
    }
}
