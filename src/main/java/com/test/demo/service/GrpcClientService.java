package com.test.demo.service;

import org.springframework.stereotype.Service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import room.Hello.CreateRoomReply;
import room.Hello.CreateRoomRequest;
import room.Hello.EndRoomReply;
import room.Hello.EndRoomRequest;
import room.Hello.GetRoomsReply;
import room.Hello.GetRoomsRequest;
import room.Hello.Room;
import room.Hello.UpdateRoomReply;
import room.Hello.UpdateRoomRequest;
import room.RoomServiceGrpc;

@Service
public class GrpcClientService {
	
	@GrpcClient("test")
	private RoomServiceGrpc.RoomServiceBlockingStub roomStud;

	public void getRoom() {
		
		try {
			
			GetRoomsReply reply = roomStud.getRooms(GetRoomsRequest.newBuilder().setTest(true).build()); 
			
			System.out.println(reply);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void createRoom() {
		
		CreateRoomRequest request = CreateRoomRequest.newBuilder()
				.setRoom(Room.newBuilder()
							.setSid("sid")
							.setName("NewRoom")
							.setLock(false)
							.setDescription("new room")
							.setMaxPeers(10)
							.build()
						).build();
		
		CreateRoomReply reply = roomStud.createRoom(request);
		
		System.out.println(reply);
		
		
	}
	
	public void updateRoom() {
		
		UpdateRoomRequest request = UpdateRoomRequest.newBuilder()
					.setRoom(Room.newBuilder()
							.setSid("sid")
							.setName("updateRoom")
							.setDescription("Update Room")
							).build();
		
		UpdateRoomReply reply = roomStud.updateRoom(request);
		
		System.out.println(reply);
		
	}
	
	public void endRoom() {
		EndRoomRequest request = EndRoomRequest.newBuilder()
				.setSid("sid")
				.setReason("test")
				.setDelete(true)
				.build();
		
		EndRoomReply reply = roomStud.endRoom(request);
		
		System.out.println(reply);
	}
	
	


}
