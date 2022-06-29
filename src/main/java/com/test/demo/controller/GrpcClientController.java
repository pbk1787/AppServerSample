package com.test.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.service.GrpcClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grpc")
public class GrpcClientController {
	
	private final GrpcClientService grpcClientService;
	
	@GetMapping("/rooms")
	public void getRoom() {
		System.out.println("Room GET 프로시저 호출 ** ");
		grpcClientService.getRoom();
	}
	
	@PostMapping("/rooms")
	public void create() {
		System.out.println("Room create 프로시저 호출 ** ");
		grpcClientService.createRoom();
	}
	
	@PutMapping("/rooms")
	public void update() {
		System.out.println(" Room update 프로시저 호출 ");
		grpcClientService.updateRoom();
	}
	
	@DeleteMapping("/rooms")
	public void delete() {
		System.out.println(" Room Delete 프시저 호");
		grpcClientService.endRoom();
	}
	
}
