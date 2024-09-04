package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.ImmBienBailDTO;
import com.yewi.yewicore.recuperation.service.ImmBienBailService;
import com.yewi.yewicore.recuperation.vo.ImmBienBailQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienBailUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienBailVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/immBienBail")
public class ImmBienBailController {

    @Autowired
    private ImmBienBailService immBienBailService;

    @PostMapping
    public String save(@Valid @RequestBody ImmBienBailVO vO) {
        return immBienBailService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        immBienBailService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ImmBienBailUpdateVO vO) {
        immBienBailService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ImmBienBailDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return immBienBailService.getById(id);
    }

    @GetMapping
    public Page<ImmBienBailDTO> query(@Valid ImmBienBailQueryVO vO) {
        return immBienBailService.query(vO);
    }
}
