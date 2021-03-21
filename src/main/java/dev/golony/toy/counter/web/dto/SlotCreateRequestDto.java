package dev.golony.toy.counter.web.dto;

import dev.golony.toy.counter.domain.Slot;
import lombok.Getter;

@Getter
public class SlotCreateRequestDto {
    private String slotName;
    private Long maxSlot;

    public Slot toSlot(){
        return Slot.builder()
                        .slotName(slotName)
                        .maxSlot(maxSlot)
                        .build();
    }
}
