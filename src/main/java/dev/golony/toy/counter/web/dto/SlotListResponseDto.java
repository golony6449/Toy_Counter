package dev.golony.toy.counter.web.dto;

import dev.golony.toy.counter.domain.Slot;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SlotListResponseDto {
    private String slotName;
    private List<String> currUserName;
    private String expireHour;
    private String expireMinute;

    public SlotListResponseDto(Slot slot){
        this.slotName = slot.getSlotName();
        this.expireHour = Integer.toString(slot.getExpireTime().getHour());
        this.expireMinute = Integer.toString(slot.getExpireTime().getMinute());

        //        this.currUserName = slot.getCurrUser().stream().map().collect(Collectors.toList());
        List<String> listUserName = new ArrayList<>();
        slot.getCurrUser().forEach((user) -> {
            listUserName.add(user.getName());
        });

        this.currUserName = listUserName;
    }
}
