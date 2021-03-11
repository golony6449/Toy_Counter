package dev.golony.toy.counter.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Builder
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String homeAddr;

    private String mobileTlno;
    private String homeTel;
    private boolean isCircleMember;
    private boolean isStaff;

    @OneToOne
    private School school;
}
