package kopo.poly.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// 1. 만약 @Getter, @Setter를 쓰지 않으면 StudentDTO를 어떻게 바꿔야 하는지 쓰라고 함

public class StudentDTO {

    private String userId;

    private String userName;

    private String email;

    private String addr;
}
