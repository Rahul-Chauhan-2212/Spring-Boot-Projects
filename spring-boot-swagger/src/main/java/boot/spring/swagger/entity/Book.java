package boot.spring.swagger.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ApiModelProperty(example = "Auto Generated Value", accessMode = AccessMode.READ_ONLY)
	private int id;

	private String bookname;

	private String author;

	private double price;

}
