package com.test.demo.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(description = "채팅방 관련 VO")
public class RoomVO implements Serializable{
	
	@ApiModelProperty(value="노드 번호", hidden = true)
	private String nodeNum;
	
//	@ApiModelProperty(value="채팅방 아이디", required = true)
	@ApiModelProperty(value="채팅방 아이디", hidden=true)
	private String roomId;
	
	@ApiModelProperty(value="채팅방명", required = true)
	private String roomName;
	
	@ApiModelProperty(value="등록자 아이디", required = true)
	private String regUserId;
	
	@ApiModelProperty(value="현재 인원", hidden=true)
	private int nowPeerSize;
	
	@ApiModelProperty(value="최대 인원", example = "10")
	private int maxPeerSize;

}
