package com.test.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.dto.RoomVO;
import com.test.demo.service.RoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Api(tags = {"1. 채팅방 "})
@RestController
@RequestMapping("/rooms")
public class RoomController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final RoomService roomService;
	
	
	@ApiOperation(value="채팅방 리스트", notes = "채팅방 리스트 가져오기", response = List.class)
	@GetMapping
	public List<RoomVO> getRooms() {
		List<RoomVO> list = roomService.getRoomList();
		return list;
	}
	
	
	@ApiOperation(value="채팅방 생성", notes="채팅방 생성하기", response = String.class)
	@PostMapping(produces = "application/json")
	public String postRooms(@RequestBody RoomVO roomVo) {
		return roomService.createRoom(roomVo);
	}
	
	
	@ApiOperation(value="채팅방 정보", notes="채팅방 정보 상세보기", response = RoomVO.class)
	@GetMapping(value = "/{id}")
	public RoomVO getRoomInfo(@PathVariable(value="id") String roomId) {
		return roomService.getRoomInfo(roomId);
	}
	
	@ApiOperation(value="채팅방 삭제", notes="채팅방 삭제하기",response = String.class)
	@DeleteMapping(value = "/{id}")
	public String deleteRoom(@PathVariable(value="id") String roomId) {
		return roomService.deleteRoom(roomId);
	}
	
	
	@ApiOperation(value="채팅방 수정", notes="채팅방 수정하기",response = String.class)
	@PutMapping(value = "/{id}")
	public String updateRoom(@PathVariable(value="id") String roomId, @RequestBody RoomVO roomVo) {
		roomVo.setRoomId(roomId);
		return roomService.updateRoom(roomVo);
	}

}