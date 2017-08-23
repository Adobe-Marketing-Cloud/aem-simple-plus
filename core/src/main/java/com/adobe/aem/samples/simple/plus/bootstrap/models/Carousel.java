package com.adobe.aem.samples.simple.plus.bootstrap.models;

import java.util.Collection;

public interface Carousel {
	
	public static String ITEMS_NODE = "carouselitems";

	Collection<CarouselItem> getItems();
	
	String getId();
}
