package com.lq.anyRule;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest(classes = com.lq.anyRule.anyRule.class)
public class anyRule {

    @Test
    public void test01(){
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

       // Scanner scan = new Scanner(System.in);

        String email = "1878834140@qq.com";

        boolean result = email.matches(regex);

        System.out.println(result);
    }

}
