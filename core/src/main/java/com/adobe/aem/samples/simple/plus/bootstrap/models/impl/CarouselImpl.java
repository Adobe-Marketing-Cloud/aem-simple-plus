package com.adobe.aem.samples.simple.plus.bootstrap.models.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.aem.samples.simple.plus.bootstrap.models.Carousel;
import com.adobe.aem.samples.simple.plus.bootstrap.models.CarouselItem;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Carousel.class, resourceType = CarouselImpl.RESOURCE_TYPE)
@Exporter(name = "jackson", extensions = "json")
public class CarouselImpl implements Carousel {
	
	protected static final String RESOURCE_TYPE = "simple/plus-bootstrap/components/content/carousel";
	
	private static final Logger log = LoggerFactory.getLogger(CarouselImpl.class);
	
	@SlingObject
	private Resource resource;
	
	private Resource carouselItemsResource;
	
	private String resourceId;
	
	private List<CarouselItem> items;
	
	@PostConstruct
	private void initModel() {
		carouselItemsResource = resource.getChild(ITEMS_NODE); 
		resourceId = resource.getParent().getName() + "-" + resource.getName();
	}

	@Override
	public Collection<CarouselItem> getItems() {
		if (items == null) {
			items = new ArrayList<>();
			collectCarouselItems();
		}
		return items;
	}

	private void collectCarouselItems() {
		log.info("how many times are we called?");
		if(carouselItemsResource != null) {
			Iterator<Resource> childResources = carouselItemsResource.listChildren();
			while(childResources.hasNext()) {
				Resource childRes = childResources.next();
				CarouselItem carouselItem = new CarouselItemImpl(childRes.getValueMap());
				if(carouselItem != null) {
					items.add(carouselItem);
				}
			}
		}	
	}

	@Override
	public String getId() {
		return resourceId;
	}

}
