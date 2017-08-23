package com.adobe.aem.samples.simple.plus.bootstrap.models.impl;

import org.apache.sling.api.resource.ValueMap;

import com.adobe.aem.samples.simple.plus.bootstrap.models.CarouselItem;

public class CarouselItemImpl implements CarouselItem {
	
	private String imagePath;
	private String headline;
	private String ctapath;
	private String ctalabel;
	private String description;
	
	public CarouselItemImpl(ValueMap properties) {
		this.imagePath = properties.get(PN_IMAGE, String.class);
		this.headline = properties.get(PN_HEADLINE, String.class);
		this.ctapath = properties.get(PN_CTAPATH, String.class);
		this.ctalabel = properties.get(PN_CTALABEL, String.class);
		this.description = properties.get(PN_DESCRIPTION, String.class);
	}

	@Override
	public String getImage() {
		return imagePath;
	}

	@Override
	public String getHeadline() {
		return headline;
	}

	@Override
	public String getCtaPath() {
		return ctapath;
	}

	@Override
	public String getCtaLabel() {
		return ctalabel;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
