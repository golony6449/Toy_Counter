package dev.golony.toy.counter.service;

import dev.golony.toy.counter.domain.Slot;
import dev.golony.toy.counter.domain.SlotRepository;
import dev.golony.toy.counter.web.dto.SlotCreateRequestDto;
import dev.golony.toy.counter.web.dto.SlotListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SlotService {
    SlotRepository slotRepository;

    @Transactional
    public Long create(SlotCreateRequestDto dto){
        Slot newSlot = dto.toSlot();

        return slotRepository.save(newSlot).getId();
    }

    @Transactional(readOnly = true)
    public List<SlotListResponseDto> getAll(){
        return slotRepository.findAll().stream()
                .map(SlotListResponseDto::new).collect(Collectors.toList());
    }

    // TODO: 관리자용 update, 사용자등록 update 분리?
//    @Transactional
//    public Long update(Long id){
//        Slot slot = slotRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 시설물입니다."));
//
//        slot.update()
//    }

    @Transactional
    public void expire(Long id){
        Slot slot = slotRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 시설물입니다."));

        slot.expire();

    }
}
