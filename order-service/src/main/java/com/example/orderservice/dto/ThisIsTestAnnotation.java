package com.example.orderservice.dto;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
@Target({ElementType.TYPE})
public @interface ThisIsTestAnnotation {

    /*
    * [커스텀 어노테이션을 위한 기본 지식]
    * @Retention
    * - 어노테이션이 지속 시간을 지정한다.
    *   - SOURCE: 컴파일 이후 사라짐. 컴파일 완료 후 바이트 코드에 기록 X (ex @Override, @SuppressWarnings)
    *   - CLASS: default 값. 컴파일 시점에만 .class 파일에 존재한다. 런타임 때는 사라진다. 따라서 바이트 코드 레벨에서 어떤 작업이
    *           필요하면 사용한다.
    *   - RUNTIME: 커스텀 어노테이션을 생성할 때 주로 사용한다. 런타임 시에도 .class 파일에 존재하며, Reflection 사용이 가능하다.
    *
    * @Target
    * - 어노테이션을 작성할 곳을 지정한다.
    * - default 값은 모든 대상
    * - 범위를 좁혀 세부적으로 지정할 수 있다.
    *   - TYPE -> class, interface, enum
    *   - FIELD -> instance variable
    *   - METHOD
    *   - PARAMETER
    *   - CONSTRUCTOR
    *   - LOCAL_VARIABLE
    *   - ANNOTATION_TYPE (apply on another annotation)
    *   - PACKAGE
    * - @Target({ElementType.TYPE, ElementType.FIELD}) 으로 다수의 타겟을 정할 수 있다.
    * - 눈여겨 볼 점은, 어노테이션을 중첩시킬 수 있다는 점이다.
    * Spring Data JPA, Spring Security 등 사이즈가 큰 라이브러리에는 어노테이션이 여러 계층으로
    * 복잡하게 지정되어 있음을 확인할 수 있다.
    *
    * @Inherited
    * - 자식 클래스에 상속이 가능하도록 허용할지 여부를 결정한다.
    * */

}
