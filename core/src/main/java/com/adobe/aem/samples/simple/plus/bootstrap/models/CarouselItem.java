package com.adobe.aem.samples.simple.plus.bootstrap.models;

public interface CarouselItem {
	
	String PN_IMAGE = "image";
	
	String PN_HEADLINE = "headline";
	
	String PN_CTAPATH = "ctapath";
	
	String PN_CTALABEL = "ctalabel";
	
	String PN_DESCRIPTION = "description";
	
	String getImage();
	
	String getHeadline();
	
	String getCtaPath();
	
	String getCtaLabel();
	
	String getDescription();
	
	

}
