package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.SecteursDTO;
import com.yewi.yewicore.recuperation.service.SecteursService;
import com.yewi.yewicore.recuperation.vo.SecteursQueryVO;
import com.yewi.yewicore.recuperation.vo.SecteursUpdateVO;
import com.yewi.yewicore.recuperation.vo.SecteursVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/secteurs")
public class SecteursController {

    @Autowired
    private SecteursService secteursService;

    @PostMapping
    public String save(@Valid @RequestBody SecteursVO vO) {
        return secteursService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        secteursService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody SecteursUpdateVO vO) {
        secteursService.update(id, vO);
    }

    @GetMapping("/{id}")
    public SecteursDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return secteursService.getById(id);
    }

    @GetMapping
    public Page<SecteursDTO> query(@Valid SecteursQueryVO vO) {
        return secteursService.query(vO);
    }
}
