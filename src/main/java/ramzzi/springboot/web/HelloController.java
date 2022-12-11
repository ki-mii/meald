package ramzzi.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ramzzi.springboot.web.dto.HelloResponseDto;

@RestController
//JSON을 반환하는 컨트롤러를 만들어 줌. 각 메소드마다 선언했던 ResponseBody 대신에 한번에 사용할 수 있게 해줌.
public class HelloController {

    @GetMapping("/hello")
    //HTTP method인 GET의 요청을 받을수 있는 API를 만들어 줌.
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
