package br.com.fmchagas.intazp.domain.post;

import org.springframework.web.multipart.MultipartFile;

public interface Uploader {
	public String upload(MultipartFile file);
}