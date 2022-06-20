package com.web.root.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.mybatis.review.ReviewMapper;
import com.web.root.review.dto.ReviewDTO;
import com.web.root.review.dto.ReviewImageDTO;
import com.web.root.review.service.ReviewFileService;
import com.web.root.review.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	private ReviewService reviewService;

	@RequestMapping(value = "/writePage/{id}", method = RequestMethod.GET)
	public ModelAndView reviewPage(@PathVariable String id, Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return new ModelAndView("cafe/writeReview", map, HttpStatus.OK);

	}

	@RequestMapping(value = "/cafe", method = RequestMethod.GET)
	public ModelAndView cafeReviewDetails(@RequestParam(name = "no") String no) {

		int cafe_no = Integer.valueOf(no);
		Map<String, Object> map = new HashMap<String, Object>();
		CafeDTO cafeInfo = reviewService.cafeInfo(cafe_no);
		List<ReviewDTO> reviews = reviewService.reviewDetails(cafe_no);
		List<UploadDTO> cafeImages = reviewService.cafeImages(cafe_no);

		map.put("cafeDetail", cafeInfo);
		map.put("cafeImageLink", cafeImages);
		map.put("reviewDetail", reviews);

		for (int i = 0; i < reviews.size(); i++) {
			System.out.println(reviews.get(i).toString());
		}

		return new ModelAndView("cafe/review", map, HttpStatus.OK);
	}

	@RequestMapping(value = "/writeReview", method = RequestMethod.POST)
	public String writeReview(@RequestParam("id") String id, @RequestParam("cafeNo") String cafeNo,
			@RequestParam("content") String content, @RequestParam("grade") String grade,
			MultipartHttpServletRequest httpServletRequest) {

		List<MultipartFile> files = httpServletRequest.getMultiFileMap().get("files");
		reviewService.reviewWrite(cafeNo, id, content, grade, files);

		return "redirect:/review/cafe?no=" + cafeNo;
	}

	@RequestMapping(value = "/deleteReview/{cafe_no}/{review_no}/{id}", method = RequestMethod.POST)
	public String deleteReview(@PathVariable(name = "cafe_no") String cafe_no,
			@PathVariable(name = "review_no") String review_no, @PathVariable(name = "id") String id) {

		reviewService.deleteReview(Integer.valueOf(cafe_no), Integer.valueOf(review_no), id);

		return "redirect:/review/cafe?no=" + cafe_no;
	}

	@RequestMapping(value = "/updateReview", method = RequestMethod.POST)
	public String updateReview(@RequestParam("id") String id, @RequestParam("cafeNo") String cafeNo,
			@RequestParam("reviewNo") String reviewNo, @RequestParam("content") String content,
			@RequestParam("grade") String grade, MultipartHttpServletRequest httpServletRequest) {

		List<MultipartFile> files = httpServletRequest.getMultiFileMap().get("files");
		int cafe_no = Integer.valueOf(cafeNo);
		int review_no = Integer.valueOf(reviewNo);
		int grade_v = Integer.valueOf(grade);
		reviewService.updateReview(id, cafe_no, review_no, content, grade_v, files);

		return "redirect:/review/cafe?no=" + cafeNo;
	}

// 끝나고 지워야함	===================================================================================================

	@Autowired
	private ReviewMapper mapper;

	@Autowired
	private ReviewFileService fileService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		System.out.println(mapper.findReviewsByCafeNo(1));
	}

	@RequestMapping(value = "/cafe1", method = RequestMethod.GET)
	public ModelAndView targetReviewDetails1() {
		Map<String, Object> map = new HashMap<String, Object>();

		CafeDTO cafeInfo = new CafeDTO();
		List<ReviewDTO> review = new ArrayList<ReviewDTO>();
		cafeInfo.setCafe_name("hi");
		cafeInfo.setAvg_star(4.0);
		cafeInfo.setCafe_tel("010-0000-1111");
		cafeInfo.setKidszone(1);
		cafeInfo.setLogtime("9:00 ~ 18:00");
		cafeInfo.setMenu("hi");

		List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
		// reviewDTOs.add(new ReviewDTO(1, 1, "reviewContent", "id", "review_savedate",
		// "image", 4));

		map.put("cafeDetail", cafeInfo);
		map.put("reviewDetail", review);

		return new ModelAndView("cafe/review", map, HttpStatus.OK);
	}

	@RequestMapping(value = "/cafeSave", method = RequestMethod.POST)
	public void reviewSaveImageTest(@RequestParam("id") String id, @RequestParam("cafeNo") String cafeNo,
			@RequestParam("content") String content, @RequestParam("grade") String grade,
			MultipartHttpServletRequest httpServletRequest) {

		List<MultipartFile> files = httpServletRequest.getMultiFileMap().get("files");
		int cafe_no = Integer.valueOf(cafeNo);
		int grade_v = Integer.valueOf(grade);
		reviewService.reviewWrite(cafeNo, id, content, grade, files);
	}

	@RequestMapping(value = "/cafe12", method = RequestMethod.GET)
	public void reviewImages() {
		List<ReviewDTO> list = reviewService.reviewDetails(1);
		System.out.println(list.toString());
	}

	@RequestMapping(value = "/cafe123", method = RequestMethod.GET)
	public void reviewImagesSave() {

		List<ReviewImageDTO> reviewImages = fileService.findReviewImageByCafeNoAndReviewNoAndId(3, 4, "dong");

		System.out.println(reviewImages.toString());

	}

	@RequestMapping(value = "/cafe1234", method = RequestMethod.GET)
	public void reviewImagesSave4() {

		List<ReviewDTO> reviewImages = reviewService.reviewDetails(3);

		for (int i = 0; i < reviewImages.size(); i++) {
			System.out.println(reviewImages.get(i).toString());
		}
	}

	@RequestMapping(value = "/writeReviewTest", method = RequestMethod.POST)
	public void writeReviewTest(@RequestParam("id") String id, @RequestParam("cafeNo") String cafeNo,
			@RequestParam("content") String content, @RequestParam("grade") String grade,
			MultipartHttpServletRequest httpServletRequest) throws IllegalStateException, IOException {

		System.out.println("hi");
		List<MultipartFile> files = httpServletRequest.getMultiFileMap().get("files");

		fileService.reviewImgSave(1, 1, "donghyoen", files);

		// return "redirect:http://";
	}

	/*
	 * @RequestMapping(value = "/ormTest", method = RequestMethod.GET) public void
	 * ormTest(@RequestParam(name = "no") String no) { Map<String, Object> map = new
	 * HashMap<String, Object>();
	 * 
	 * CafeReviewDTO dto = reviewService.ormTest(Integer.valueOf(no));
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value = "/write", method = RequestMethod.POST, consumes =
	 * MediaType.MULTIPART_FORM_DATA_VALUE) public void writeReview(@ModelAttribute
	 * RequestReviewDTO reviewDTO, HttpServletRequest httpServletRequest) { String
	 * cafeNo = httpServletRequest.getParameter("cafeNo");
	 * System.out.println(cafeNo);
	 * logger.info("date => content : {} cafe_no : {}, files : {}",
	 * reviewDTO.getCafeNo(), reviewDTO.getContent()); //
	 * //reviewService.reviewWrite(cafe_no, content, multipartFile);
	 * 
	 * }
	 */
}
