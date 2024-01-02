package net.javaguides.sms.Categories;

import jakarta.annotation.Nullable;
 
import jakarta.validation.constraints.Size;


public class CategoryDTO {

	 
	private Integer categoryId;
 	
	@Nullable
	@Size(min = 4, max =  20, message = "size of tile between 4 and 20 Charactors")
  	private String categorytitle;
	@Size(min = 4, max =  20, message = "size of Description between 4 and 20 Charactors")
 	private String categoryDescription;
	
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(Integer categoryId,
			@Size(min = 4, max = 20, message = "size of tile between 4 and 20 Charactors") String categorytitle,
			@Size(min = 4, max = 20, message = "size of Description between 4 and 20 Charactors") String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categorytitle = categorytitle;
		this.categoryDescription = categoryDescription;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategorytitle() {
		return categorytitle;
	}

	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", categorytitle=" + categorytitle + ", categoryDescription="
				+ categoryDescription + "]";
	}

	 
	
}
