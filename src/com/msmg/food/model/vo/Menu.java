package com.msmg.food.model.vo;

public class Menu implements java.io.Serializable{
	private String img_name;
	private String img_src;
	private String info;
	private String name;
	private String main_grad;
	private String sub_grad;
	private int price;
	
	public Menu(){}

	public Menu(String img_name, String img_src, String info, String name, String main_grad, String sub_grad,
			int price) {
		super();
		this.img_name = img_name;
		this.img_src = img_src;
		this.info = info;
		this.name = name;
		this.main_grad = main_grad;
		this.sub_grad = sub_grad;
		this.price = price;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMain_grad() {
		return main_grad;
	}

	public void setMain_grad(String main_grad) {
		this.main_grad = main_grad;
	}

	public String getSub_grad() {
		return sub_grad;
	}

	public void setSub_grad(String sub_grad) {
		this.sub_grad = sub_grad;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Menu [img_name=" + img_name + ", img_src=" + img_src + ", info=" + info + ", name=" + name
				+ ", main_grad=" + main_grad + ", sub_grad=" + sub_grad + ", price=" + price + "]";
	}
	
	
}
