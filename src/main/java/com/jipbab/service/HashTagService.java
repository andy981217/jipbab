package com.jipbab.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jipbab.repository.HashRepository;
import com.jipbab.repository.HashRepositoryCustom;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class HashTagService {
	@Value("${hashTagLocation}")
	private String hashTagLocation;
	
	private final HashRepository hashRepository;
	
	private final FileService fileService;
}
