package com.jipbab.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.jipbab.entity.ResImg;
import com.jipbab.repository.RestImgRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RestImgService {
	@Value("${restImgLocation}")
	private String restImgLocation;

	private final RestImgRepository restImgRepostiory;

	private final FileService fileService;

	public void saveRestImg(ResImg resImg, MultipartFile restImgFile) throws Exception {
		String oriImgName = restImgFile.getOriginalFilename(); // 파일이름
		String imgName = "";
		String resImgUrl = "";
	
		if(!StringUtils.isEmpty(oriImgName)) {
			imgName = fileService.uploadFile(restImgLocation, oriImgName, restImgFile.getBytes());
			resImgUrl = "/images/rest/" + imgName;
		}
		//음식점 이미지 정보 저장
		resImg.updateResImg(oriImgName, imgName, resImgUrl);
		restImgRepostiory.save(resImg);
	}
	public void updateResImg(Long resImgId, MultipartFile resImgFile) throws Exception{
		if(!resImgFile.isEmpty()) {
			ResImg savedResImg = restImgRepostiory.findById(resImgId)
					.orElseThrow(EntityNotFoundException::new);
			
			if(!StringUtils.isEmpty(savedResImg.getImgName())) {
				fileService.deleteFile(restImgLocation+"/"+savedResImg.getImgName());
			}
			
			String oriImgName =resImgFile.getOriginalFilename();
			String imgName = fileService.uploadFile(restImgLocation, oriImgName, resImgFile.getBytes());
			String imgUrl = "/images/rest/"+imgName;
			
			savedResImg.updateResImg(oriImgName, imgName, imgUrl);
		}
	}
}
