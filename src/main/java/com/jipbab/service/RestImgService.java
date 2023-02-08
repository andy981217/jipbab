package com.jipbab.service;

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
		String res_oriImgName = restImgFile.getOriginalFilename(); // 파일이름
		String img_Name = "";
		String res_imgUrl = "";
	
		if(!StringUtils.isEmpty(res_oriImgName)) {
			img_Name = fileService.uploadFile(restImgLocation, res_oriImgName, restImgFile.getBytes());
			res_imgUrl = "/images/rest/" + img_Name;
		}
		//음식점 이미지 정보 저장
		resImg.updateResImg(res_oriImgName, img_Name, res_imgUrl);
		restImgRepostiory.save(resImg);
	}
	
}
