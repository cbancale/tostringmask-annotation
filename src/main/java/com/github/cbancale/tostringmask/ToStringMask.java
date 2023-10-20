package com.github.cbancale.tostringmask;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface ToStringMask {
    MaskType type() default MaskType.FULL;

    int len() default 10;
}
