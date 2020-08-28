package br.com.fmchagas.instazp.domain.post;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class LocalUploader implements Uploader{

	@Override
	public String upload(MultipartFile file) {
		System.out.println("enviando arquivo para estorage...");
		
		return "https://s3.amazon/bucket/" + file.getOriginalFilename();
	}

}