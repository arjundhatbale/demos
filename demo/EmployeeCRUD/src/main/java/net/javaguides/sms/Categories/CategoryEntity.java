package net.javaguides.sms.Categories;
 

 
 import jakarta.persistence.Column;
import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
 
@Entity
@Table(name="categoris")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer categoryId;
	
	@NotNull
	@Size(min = 4, max =  20, message = "size of tile between 4 and 20 Charactors")
	@Column(name="title")
	private String categorytitle;
	
	@Column(name="category_description", length = 100, nullable = false)
	private String categoryDescription;
	
//	@OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
// 	private Set<Post> posts = new HashSet<>();
//	
	
	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

public CategoryEntity(Integer categoryId,
		@NotNull @Size(min = 4, max = 20, message = "size of tile between 4 and 20 Charactors") String categorytitle,
		String categoryDescription) {
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
	return "CategoryEntity [categoryId=" + categoryId + ", categorytitle=" + categorytitle + ", categoryDescription="
			+ categoryDescription + "]";
}

 
	
}
