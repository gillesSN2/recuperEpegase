package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedCmaDTO;
import com.yewi.yewicore.recuperation.service.MedCmaService;
import com.yewi.yewicore.recuperation.vo.MedCmaQueryVO;
import com.yewi.yewicore.recuperation.vo.MedCmaUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedCmaVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medCma")
public class MedCmaController {

    @Autowired
    private MedCmaService medCmaService;

    @PostMapping
    public String save(@Valid @RequestBody MedCmaVO vO) {
        return medCmaService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medCmaService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedCmaUpdateVO vO) {
        medCmaService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedCmaDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medCmaService.getById(id);
    }

    @GetMapping
    public Page<MedCmaDTO> query(@Valid MedCmaQueryVO vO) {
        return medCmaService.query(vO);
    }
}
