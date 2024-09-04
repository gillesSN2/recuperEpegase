package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.DevisesDTO;
import com.yewi.yewicore.recuperation.service.DevisesService;
import com.yewi.yewicore.recuperation.vo.DevisesQueryVO;
import com.yewi.yewicore.recuperation.vo.DevisesUpdateVO;
import com.yewi.yewicore.recuperation.vo.DevisesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/devises")
public class DevisesController {

    @Autowired
    private DevisesService devisesService;

    @PostMapping
    public String save(@Valid @RequestBody DevisesVO vO) {
        return devisesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        devisesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody DevisesUpdateVO vO) {
        devisesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DevisesDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return devisesService.getById(id);
    }

    @GetMapping
    public Page<DevisesDTO> query(@Valid DevisesQueryVO vO) {
        return devisesService.query(vO);
    }
}
