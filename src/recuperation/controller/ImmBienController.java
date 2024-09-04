package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.ImmBienDTO;
import com.yewi.yewicore.recuperation.service.ImmBienService;
import com.yewi.yewicore.recuperation.vo.ImmBienQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/immBien")
public class ImmBienController {

    @Autowired
    private ImmBienService immBienService;

    @PostMapping
    public String save(@Valid @RequestBody ImmBienVO vO) {
        return immBienService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        immBienService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ImmBienUpdateVO vO) {
        immBienService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ImmBienDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return immBienService.getById(id);
    }

    @GetMapping
    public Page<ImmBienDTO> query(@Valid ImmBienQueryVO vO) {
        return immBienService.query(vO);
    }
}
