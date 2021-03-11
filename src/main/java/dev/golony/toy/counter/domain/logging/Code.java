package dev.golony.toy.counter.domain.logging;


import dev.golony.toy.counter.domain.BaseTimeEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Code extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeNm;

}
