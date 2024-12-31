package com.demo.sample.dto.request;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

// @Data = @Getter + @Setter + @EqualsHashCode + @ToString => Redundant
// @Getter(AccessLevel.PROTECTED) => change access modifier
@Getter(AccessLevel.MODULE)
@Builder
public class SampleDTO implements Serializable {
    private Integer id;
    private String name;
}
