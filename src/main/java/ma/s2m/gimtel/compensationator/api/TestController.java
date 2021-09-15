package ma.s2m.gimtel.compensationator.api;


import ma.s2m.gimtel.compensationator.service.CompensationFileGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private CompensationFileGeneratorService compensationFileGeneratorService;


    @GetMapping("/process")
    public void process() throws Exception{
        compensationFileGeneratorService.handle();
    }
}
