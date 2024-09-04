package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.ServicesDTO;
import com.yewi.yewicore.recuperation.service.ServicesService;
import com.yewi.yewicore.recuperation.vo.ServicesQueryVO;
import com.yewi.yewicore.recuperation.vo.ServicesUpdateVO;
import com.yewi.yewicore.recuperation.vo.ServicesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @PostMapping
    public String save(@Valid @RequestBody ServicesVO vO) {
        return servicesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        servicesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ServicesUpdateVO vO) {
        servicesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ServicesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return servicesService.getById(id);
    }

    @GetMapping
    public Page<ServicesDTO> query(@Valid ServicesQueryVO vO) {
        return servicesService.query(vO);
    }
}
