package com.jipbab.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jipbab.dto.MainRestDto;
import com.jipbab.dto.RestSearchDto;
import com.jipbab.entity.Restaurant;

public interface RestRepositoryCustom {
	Page<Restaurant> getAdminRestPage(RestSearchDto restSearchDto, Pageable pageable);

	Page<MainRestDto> getMainRestPage(RestSearchDto restSearchDto, Pageable pageable);
}
