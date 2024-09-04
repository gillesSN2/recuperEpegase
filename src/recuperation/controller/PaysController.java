package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaysDTO;
import com.yewi.yewicore.recuperation.service.PaysService;
import com.yewi.yewicore.recuperation.vo.PaysQueryVO;
import com.yewi.yewicore.recuperation.vo.PaysUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaysVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/pays")
public class PaysController {

    @Autowired
    private PaysService paysService;

    @PostMapping
    public String save(@Valid @RequestBody PaysVO vO) {
        return paysService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        paysService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody PaysUpdateVO vO) {
        paysService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaysDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return paysService.getById(id);
    }

    @GetMapping
    public Page<PaysDTO> query(@Valid PaysQueryVO vO) {
        return paysService.query(vO);
    }
}
