package com.lvc.foodfinder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lvc.database.EntitiePersistable;
import com.lvc.database.annotation.PrimaryKey;

public class Food implements EntitiePersistable {

	 
	private static final long serialVersionUID = 2796747829951738545L;
	
	public static final String FOOD_LIST_BUNDLE_NAME = "FOOD_LIST_BUNDLE_NAME";
	public static final String FOOD_DETAIL_BUNDLE_NAME = "FOOD_DETAIL_BUNDLE_NAME";
	
	@PrimaryKey
	private int id;
	
	@JsonProperty("categoryid")
	private int categoryId;
	
	private double fiber;
	
	@JsonProperty("headimage")
	private String headImage;
	
	private int pcsingram;
	
	private String brand;
	
	@JsonProperty("unsaturatedfat")
	private double unsaturatedFat;
	
	private double fat;
	
	@JsonProperty("servingcategory")
	private int servingCategory;
	
	@JsonProperty("typeofmeasurement")
	private int typeOfMeasurement;
	
	private double protein;
	
	@JsonProperty("defaultserving")
	private int defaultserving;
	
	private int mlingram;
	
	private double saturatedfat;
	
	private String category;
	
	private boolean verified;
	
	private String title;
	
	private String pcstext;
	
	private double sodium;
	
	private double carbohydrates;
	
	@JsonProperty("showonlysametype")
	private int showOnlySameType;
	
	private int calories;
	
	@JsonProperty("serving_version")
	private int servingVersion;
	
	private double sugar;
	
	@JsonProperty("measurementid")
	private int measurementId;
	
	private double cholesterol;
	@JsonProperty("gramsperserving")
	
	private int gramsperServing;
	
	@JsonProperty("showmeasurement")
	private int showMeasurement;
	
	private double potassium;
	
	public Food() {
	}
	
	

	public Food(int id, double fiber, String brand, int unsaturatedFat, double fat, double protein, int mlingram, double saturatedfat,
			String category, boolean verified, String title, String pcstext, double sodium, double carbohydrates, int showOnlySameType, int calories,
			int servingVersion, double sugar, double cholesterol, double potassium) {
		super();
		this.id = id;
		this.fiber = fiber;
		this.brand = brand;
		this.unsaturatedFat = unsaturatedFat;
		this.fat = fat;
		this.protein = protein;
		this.mlingram = mlingram;
		this.saturatedfat = saturatedfat;
		this.category = category;
		this.verified = verified;
		this.title = title;
		this.pcstext = pcstext;
		this.sodium = sodium;
		this.carbohydrates = carbohydrates;
		this.showOnlySameType = showOnlySameType;
		this.calories = calories;
		this.servingVersion = servingVersion;
		this.sugar = sugar;
		this.cholesterol = cholesterol;
		this.potassium = potassium;
	}
 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public double getFiber() {
		return fiber;
	}

	public void setFiber(double fiber) {
		this.fiber = fiber;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public int getPcsingram() {
		return pcsingram;
	}

	public void setPcsingram(int pcsingram) {
		this.pcsingram = pcsingram;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getUnsaturatedFat() {
		return unsaturatedFat;
	}

	public void setUnsaturatedFat(double unsaturatedFat) {
		this.unsaturatedFat = unsaturatedFat;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public int getServingCategory() {
		return servingCategory;
	}

	public void setServingCategory(int servingCategory) {
		this.servingCategory = servingCategory;
	}

	public int getTypeOfMeasurement() {
		return typeOfMeasurement;
	}

	public void setTypeOfMeasurement(int typeOfMeasurement) {
		this.typeOfMeasurement = typeOfMeasurement;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public int getDefaultserving() {
		return defaultserving;
	}

	public void setDefaultserving(int defaultserving) {
		this.defaultserving = defaultserving;
	}

	public int getMlingram() {
		return mlingram;
	}

	public void setMlingram(int mlingram) {
		this.mlingram = mlingram;
	}

	public double getSaturatedfat() {
		return saturatedfat;
	}

	public void setSaturatedfat(double saturatedfat) {
		this.saturatedfat = saturatedfat;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPcstext() {
		return pcstext;
	}

	public void setPcstext(String pcstext) {
		this.pcstext = pcstext;
	}

	public double getSodium() {
		return sodium;
	}

	public void setSodium(double sodium) {
		this.sodium = sodium;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public int getShowOnlySameType() {
		return showOnlySameType;
	}

	public void setShowOnlySameType(int showOnlySameType) {
		this.showOnlySameType = showOnlySameType;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getServingVersion() {
		return servingVersion;
	}

	public void setServingVersion(int servingVersion) {
		this.servingVersion = servingVersion;
	}

	public double getSugar() {
		return sugar;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public int getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(int measurementId) {
		this.measurementId = measurementId;
	}

	public double getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
	}

	public int getGramsperServing() {
		return gramsperServing;
	}

	public void setGramsperServing(int gramsperServing) {
		this.gramsperServing = gramsperServing;
	}

	public int getShowMeasurement() {
		return showMeasurement;
	}

	public void setShowMeasurement(int showMeasurement) {
		this.showMeasurement = showMeasurement;
	}

	public double getPotassium() {
		return potassium;
	}

	public void setPotassium(double potassium) {
		this.potassium = potassium;
	}
	
	@Override
	public String toString() {
		return title + " " + brand + " " + category;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + calories;
		long temp;
		temp = Double.doubleToLongBits(carbohydrates);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + categoryId;
		temp = Double.doubleToLongBits(cholesterol);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + defaultserving;
		temp = Double.doubleToLongBits(fat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fiber);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + gramsperServing;
		result = prime * result + ((headImage == null) ? 0 : headImage.hashCode());
		result = prime * result + id;
		result = prime * result + measurementId;
		result = prime * result + mlingram;
		result = prime * result + pcsingram;
		result = prime * result + ((pcstext == null) ? 0 : pcstext.hashCode());
		temp = Double.doubleToLongBits(potassium);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(protein);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saturatedfat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + servingCategory;
		result = prime * result + servingVersion;
		result = prime * result + showMeasurement;
		result = prime * result + showOnlySameType;
		temp = Double.doubleToLongBits(sodium);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sugar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + typeOfMeasurement;
		temp = Double.doubleToLongBits(unsaturatedFat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (verified ? 1231 : 1237);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (calories != other.calories)
			return false;
		if (Double.doubleToLongBits(carbohydrates) != Double.doubleToLongBits(other.carbohydrates))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (Double.doubleToLongBits(cholesterol) != Double.doubleToLongBits(other.cholesterol))
			return false;
		if (defaultserving != other.defaultserving)
			return false;
		if (Double.doubleToLongBits(fat) != Double.doubleToLongBits(other.fat))
			return false;
		if (Double.doubleToLongBits(fiber) != Double.doubleToLongBits(other.fiber))
			return false;
		if (gramsperServing != other.gramsperServing)
			return false;
		if (headImage == null) {
			if (other.headImage != null)
				return false;
		} else if (!headImage.equals(other.headImage))
			return false;
		if (id != other.id)
			return false;
		if (measurementId != other.measurementId)
			return false;
		if (mlingram != other.mlingram)
			return false;
		if (pcsingram != other.pcsingram)
			return false;
		if (pcstext == null) {
			if (other.pcstext != null)
				return false;
		} else if (!pcstext.equals(other.pcstext))
			return false;
		if (Double.doubleToLongBits(potassium) != Double.doubleToLongBits(other.potassium))
			return false;
		if (Double.doubleToLongBits(protein) != Double.doubleToLongBits(other.protein))
			return false;
		if (Double.doubleToLongBits(saturatedfat) != Double.doubleToLongBits(other.saturatedfat))
			return false;
		if (servingCategory != other.servingCategory)
			return false;
		if (servingVersion != other.servingVersion)
			return false;
		if (showMeasurement != other.showMeasurement)
			return false;
		if (showOnlySameType != other.showOnlySameType)
			return false;
		if (Double.doubleToLongBits(sodium) != Double.doubleToLongBits(other.sodium))
			return false;
		if (Double.doubleToLongBits(sugar) != Double.doubleToLongBits(other.sugar))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (typeOfMeasurement != other.typeOfMeasurement)
			return false;
		if (Double.doubleToLongBits(unsaturatedFat) != Double.doubleToLongBits(other.unsaturatedFat))
			return false;
		if (verified != other.verified)
			return false;
		return true;
	}
	
	

}
