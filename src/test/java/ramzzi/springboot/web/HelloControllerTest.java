package ramzzi.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
//JUnit에 내장된 실행자 외에 다른 실행자(SpringRunner라는)를 실행. 스프링부트 테스트와 JUnit 사이에 연결자 역할.
@WebMvcTest(controllers =  HelloController.class) //web(spring mvc) 테스트용 annotation
public class HelloControllerTest {

    @Autowired //스프링이 관리하는 bean을 주입 받음.
    private MockMvc mvc; //spring mvc 테스트의 시작점

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // "/hello" 로 HTTP GET 요청
                .andExpect(status().isOk())  // status : 200 검증
                .andExpect(content().string(hello)); // content : hello 검증
    }

    @Test
    public void helloDto_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name) //param 메소드로 요청 파라미터 설정
                        .param("amount", String.valueOf(amount))) //String(문자열)만 가능
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //jsonPath: JSON 응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.amount", is(amount))); // $ 기준으로 필드명 명시
    }
}
