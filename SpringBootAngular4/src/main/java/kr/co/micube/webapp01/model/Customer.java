package kr.co.micube.webapp01.model;
import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
 
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
 

	@Column(name = "imagename")
	private String imageName;
	
	@Column(name = "image")
	private String image;
	

 
	protected Customer() {
	}
 
	public long getId() {
		return id;
	}
 
	public void setId(long id) {
		this.id = id;
	}
 
 
	public String getImageName() {
		return imageName;
	}
 
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
 
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	
	public Customer( String imageName,String image) {
		this.imageName = imageName;
		this.image = image;
	}
 
	@Override
	public String toString() {
		return String.format("Customer[id=%d, imageName='%s', image='%s']", id, imageName, image);
	}
}