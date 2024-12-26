package hust.soict.dsai.aims.media;
import java.util.Comparator;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.Comparator;
public abstract class Media implements Comparable<Media> {
		private int id = 0;
		private String title;
		private String category;
		private float cost;
		
		public static final Comparator<Media> COMPARE_BY_TITLE_COST =
				new MediaComparatorByTitleCost();
		public static final Comparator<Media> COMPARE_BY_COST_TITLE =
				new MediaComparatorByCostTitle();
		
		public Media() {
			// TODO Auto-generated constructor stub
			
		}
		
		public Media(String title, String category, float cost) {
			this.title = title;
			this.category = category;
			this.cost = cost;
		}
		public Media(String title, String category,int id, float cost) {
			this.title = title;
			this.category = category;
			this.cost = cost;
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public float getCost() {
			return cost;
		}
		public void setCost(float cost) {
			this.cost = cost;
		}
		
		public boolean equal(Object o) {
			Media m = (Media) o;
			if (m.title == this.title) {
				return true;
			} else {
				return false;
			}
		}
		
		public String toString() {
			String Media_string = "Media" + " - " + this.getTitle() + " - " + this.getCategory() +" - "
					+ this.getCategory() + " - "+": " + this.getCost() + " $";
			 return Media_string;
		}
		
		public String playScreen() {return null;};
		
		
	}
