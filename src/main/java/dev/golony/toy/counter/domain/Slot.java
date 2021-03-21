package dev.golony.toy.counter.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Builder
public class Slot extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slotName;

    @OneToOne
    private User currUser;

    private LocalDateTime expireTime;

    boolean isExpired(){
        LocalDateTime current = LocalDateTime.now();

        return expireTime.isAfter(current);
    }
}
