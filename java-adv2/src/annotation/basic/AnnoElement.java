package annotation.basic;

import util.MyLogger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *  Annotation 정의 규칙
 *
 *  기본타입(int, boolean, float 등)
 *  String
 *  Class(메타데이터) 또는 인터페이스
 *  enum
 *  다른 Annotation 타입
 *  위 타입들의 배결
 *
 *  외에는 정의할 수 없다(일반적인 클래스들은 불가)
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoElement {

    String value();
    int count() default 0; //기본값 적용 가능
    String[] tags() default {};

    //  MyLogger data(); //다른 타입은 적용x
    Class<? extends MyLogger> annoDate() default MyLogger.class; //클래스 정보는 가능

}
