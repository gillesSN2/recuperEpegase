package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.OptionsTiersDTO;
import com.yewi.yewicore.recuperation.service.OptionsTiersService;
import com.yewi.yewicore.recuperation.vo.OptionsTiersQueryVO;
import com.yewi.yewicore.recuperation.vo.OptionsTiersUpdateVO;
import com.yewi.yewicore.recuperation.vo.OptionsTiersVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/optionsTiers")
public class OptionsTiersController {

    @Autowired
    private OptionsTiersService optionsTiersService;

    @PostMapping
    public String save(@Valid @RequestBody OptionsTiersVO vO) {
        return optionsTiersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        optionsTiersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody OptionsTiersUpdateVO vO) {
        optionsTiersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public OptionsTiersDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return optionsTiersService.getById(id);
    }

    @GetMapping
    public Page<OptionsTiersDTO> query(@Valid OptionsTiersQueryVO vO) {
        return optionsTiersService.query(vO);
    }
}
