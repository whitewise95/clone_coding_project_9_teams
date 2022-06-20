package com.clonecodingproject.clone_coding_project_9_teams.service;

import com.clonecodingproject.clone_coding_project_9_teams.domain.*;
import com.clonecodingproject.clone_coding_project_9_teams.dto.ImageRequestDto;
import com.clonecodingproject.clone_coding_project_9_teams.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.*;

import java.io.File;
import java.util.*;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public List<ImageUrl> imageSave(List<ImageRequestDto> imageRequestDtos) {
        List<ImageUrl> imageUrls = new ArrayList<>();

        if (Optional.ofNullable(imageRequestDtos).isPresent()) {
            for (ImageRequestDto imageRequestDto : imageRequestDtos) {
                imageUrls.add(new ImageUrl(imageRequestDto));
            }
        }

        return imageRepository.saveAll(imageUrls);
    }

    @Transactional
    public String imagesUpload(MultipartHttpServletRequest request) {
        List<MultipartFile> files = request.getFiles("file");
        return null;
    }

    public void imageUpdateToPost(List<ImageUrl> imageUrls, Post post) {
        for (ImageUrl imageUrl : imageUrls) {
            imageUrl.updateToPost(post);
        }
    }

    private void imageAllDeleteByPostId(Long postId) {
        imageRepository.deleteByPostId(postId);
    }

    public List<ImageUrl> ImageOverallPatch(Long postId, List<ImageRequestDto> imageRequestDtos) {
        imageAllDeleteByPostId(postId);  //이미지 삭제
        return imageSave(imageRequestDtos); //이미지 추가
    }

    public String imageUpload(MultipartFile attcFile) {
        String rtnVal = "";
        try {
            String storedFileName = makeFileName(attcFile);
            String folder = makeDir();

            File f = new File(folder);

            if (!f.exists()) {
                f.mkdirs();
            } //폴더가 존재하지 않으면 경로 생성

//            attcFile.transferTo(new File(folder + "\\" + storedFileName));
//            rtnVal += "images\\" + storedFileName;
            attcFile.transferTo(new File(folder + "/" + storedFileName));
            rtnVal +=  "http://whitewise.shop/upload/" + storedFileName;
        } catch (Exception e) {
            rtnVal = "";
        }
        return rtnVal;
    }

    public String makeDir() {
//        return  new File("").getAbsolutePath() + "\\src\\main\\resources\\static\\images";
        return "/home/ubuntu/upload";
    }

    public String makeFileName(MultipartFile attcFile) {
        String attcFileNm = UUID.randomUUID().toString().replaceAll("-", "");
        String attcFileOriNm = attcFile.getOriginalFilename();
        String attcFileOriExt = attcFileOriNm.substring(attcFileOriNm.lastIndexOf("."));
        return attcFileNm + attcFileOriExt;
    }
}
