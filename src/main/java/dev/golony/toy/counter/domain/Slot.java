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

    private Long maxSlot;
    private Long remainderSlot;

    @OneToMany
    private List<User> currUser;

    private LocalDateTime expireTime;

    boolean isExpired(){
        LocalDateTime current = LocalDateTime.now();

        return expireTime.isAfter(current);
    }

    public Long expire(){
        // TODO 사용완료 처리 로직 추가
        remainderSlot += 1;

        return this.id;
    }

    public Long register(){
        if (remainderSlot == 0) {
            throw new IllegalStateException("남은 자리가 없습니다.");
        }

        remainderSlot -= 1;

        return this.id;
    }
}
