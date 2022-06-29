package com.test.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.demo.dto.RoomVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoomService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final RedisTemplate<String, Object> redisTemplate;
	private final ObjectMapper objectMapper;
	
	private String roomListKey = "roomList";
	
	public List<RoomVO> getRoomList() {
//		List<RoomVO> roomList = objectMapper.convertValue(redisTemplate.opsForList().range(roomListKey, 0, -1), new TypeReference<List<RoomVO>>() {});
		
		List<RoomVO> roomList = new ArrayList<RoomVO>();
		
		Map<Object, Object> map = redisTemplate.opsForHash().entries(roomListKey);
		
		for(Object key : map.keySet()) {
			RoomVO value = (RoomVO) map.get(key.toString());
		    roomList.add(value);
		}
		
		logger.debug("roomList size("+roomList.size()+") ::: "+roomList);
		
		return roomList;
}
	
	public String createRoom(RoomVO roomVo) {
		
		try {
			
			Random random = new Random();
			int ranNum = random.nextInt();
			String roomId = Integer.toString(ranNum > 0 ? ranNum : ranNum * -1);
			roomVo.setRoomId(roomId);
			
			logger.debug("create room ID = "+roomId);
			
			HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
			Map<String, Object> map = new HashMap<>();
			map.put(roomId, roomVo);
			
			hashOperations.putAll(roomListKey, map);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
		
		return "SUCCESS";
	}
	
	public RoomVO getRoomInfo(String roomId) {
		
		try {
			
			RoomVO vo = (RoomVO) redisTemplate.opsForHash().get(roomListKey, roomId);
			
			logger.debug("room ID:"+roomId +" :::: "+vo);
			
			return vo;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String deleteRoom(String roomId) {
		try {
			redisTemplate.opsForHash().delete(roomListKey, roomId);
			return "SUCCESS";
		}catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
	}
	
	public String updateRoom(RoomVO roomVO) {
		try {
			redisTemplate.opsForHash().put(roomListKey, roomVO.getRoomId(), roomVO);
			logger.debug("update room ID = "+roomVO.getRoomId());
			return "SUCCESS";
		} catch (Exception e) {
			return "FAIL";
		}
	}

}